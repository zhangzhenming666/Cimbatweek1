package com.example.cimbatweek1.view.fragment;

import android.view.View;
import android.widget.Button;

import com.example.cimbatweek1.R;
import com.example.cimbatweek1.base.BaseFragment;
import com.example.cimbatweek1.view.activity.MainActivity;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class NewsFragment extends BaseFragment {

    private Button button;

    @Override
    protected int LayoutId() {
        return R.layout.layout_nesws;
    }

    @Override
    protected void initView(View inflate) {
        button = inflate.findViewById(R.id.tbn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.toMyPage();
            }
        });
    }



    @Override
    protected void initData() {

    }
}
