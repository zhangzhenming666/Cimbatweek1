package com.example.cimbatweek1.model;

import com.example.cimbatweek1.contract.IMyContract;
import com.example.cimbatweek1.util.NetUils;
import com.google.gson.Gson;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class MyModel {
    public void getMyData(final IMyContract.IModelCallback iModelCallback) {
      String url="http://blog.zhaoliang5156.cn/api/shop/shop1.json";
      NetUils.getInstance().getJson(url, new NetUils.MyCallback() {
          @Override
          public void onGetJson(String json) {
              ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
              iModelCallback.onMySuccess(shopBean);
          }

          @Override
          public void onError(Throwable throwable) {
              iModelCallback.onMyFailure(throwable);
          }
      });
    }
}
