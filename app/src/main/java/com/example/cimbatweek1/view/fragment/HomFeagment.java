package com.example.cimbatweek1.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cimbatweek1.R;
import com.example.cimbatweek1.base.BaseFragment;
import com.example.cimbatweek1.util.NetUils;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class HomFeagment extends BaseFragment {

    private TextView text_view;
    private ImageView imageView;

    @Override
    protected int LayoutId() {
        return R.layout.layout_hom;
        
    }

    @Override
    protected void initView(View inflate) {
        text_view = inflate.findViewById(R.id.tv);
        imageView = inflate.findViewById(R.id.img);
    }

    @Override
    protected void initData() {
        if (NetUils.getInstance().hasNet(getActivity())) {
            text_view.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
        } else {
            text_view.setVisibility(View.GONE);
            imageView.setVisibility(View.VISIBLE);
        }
    }
}
