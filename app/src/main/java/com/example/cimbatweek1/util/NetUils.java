package com.example.cimbatweek1.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class NetUils {
    private static NetUils netUils = new NetUils();

    private NetUils() {
    }

    public static NetUils getInstance() {
        return netUils;
    }
    //请求json
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String httpurl, final MyCallback myCallback){
        new AsyncTask<String, String, String>() {
            @Override
            protected void onPostExecute(String s) {
                //主线程
                if (TextUtils.isEmpty(s)){
                    myCallback.onError(new Exception("请求失败"));
                } else {
                    myCallback.onGetJson(s);
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                //子线程
                InputStream inputStream =null;
                String jsom="";
                try {
                    URL url = new URL(httpurl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() ==200){
                         inputStream = httpURLConnection.getInputStream();
                         jsom = io2String(inputStream);
                    } else {
                        Log.e("TAG", "doInBackground: 请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return jsom;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private String io2String(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len =-1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len =inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }
     @SuppressLint("StaticFieldLeak")
     public void getPhoto(final String photoUil, final ImageView imageView){
         new AsyncTask<String, String, Bitmap>() {
             @Override
             protected void onPostExecute(Bitmap bitmap) {
                 //主线程
                 imageView.setImageBitmap(bitmap);
             }

             @Override
             protected Bitmap doInBackground(String... strings) {
                 InputStream inputStream =null;
                 Bitmap bitmap =null;
                 try {
                     URL url = new URL(photoUil);
                     HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                     httpURLConnection.setRequestMethod("GET");
                     httpURLConnection.setReadTimeout(5000);
                     httpURLConnection.setConnectTimeout(5000);
                     httpURLConnection.connect();
                     if (httpURLConnection.getResponseCode() ==200){
                          inputStream = httpURLConnection.getInputStream();
                          bitmap = io2Bitmap(inputStream);
                     } else {
                         Log.e("TAG", "doInBackground: 请求图片失败");
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 } finally {
                     if (inputStream != null) {
                         try {
                             inputStream.close();
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                 }
                 return bitmap;
             }
         }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
     }

    private Bitmap io2Bitmap(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }
    //是否有网
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo !=null&&activeNetworkInfo.isAvailable()){
            return true;
        } else {
            return  false;
        }
    }
    //是否是Wifi
    public boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo !=null&&activeNetworkInfo.isAvailable()&&activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        } else {
            return  false;
        }

    }
    //是否是Mobile
    public boolean isMobile(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
            return true;
        } else {
            return false;
        }
    }
    //接口
    public  interface MyCallback{
        void onGetJson(String json);
        void onError(Throwable throwable);
    }
}
