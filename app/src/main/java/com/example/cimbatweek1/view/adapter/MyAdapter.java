package com.example.cimbatweek1.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cimbatweek1.R;
import com.example.cimbatweek1.base.BaseFragment;
import com.example.cimbatweek1.model.ShopBean;
import com.example.cimbatweek1.util.NetUils;

import java.util.List;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class MyAdapter extends BaseAdapter {
    List<ShopBean.DataBean> list;

    public MyAdapter(List<ShopBean.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(viewGroup.getContext(), R.layout.item_my, null);
            viewHolder.imageView = view.findViewById(R.id.img);
            viewHolder.textView = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ShopBean.DataBean dataBean = list.get(i);
        viewHolder.textView.setText(dataBean.getGoods_name());
        NetUils.getInstance().getPhoto(dataBean.getGoods_thumb(),viewHolder.imageView);
        return view;
    }
    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
