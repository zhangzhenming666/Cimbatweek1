package com.example.cimbatweek1.view.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.cimbatweek1.R;
import com.example.cimbatweek1.base.BaseFragment;
import com.example.cimbatweek1.contract.IMyContract;
import com.example.cimbatweek1.model.ShopBean;
import com.example.cimbatweek1.presenter.MyPresenter;
import com.example.cimbatweek1.view.adapter.MyAdapter;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class MyFeagment extends BaseFragment implements IMyContract.IView {

    private GridView gridView;
    private MyPresenter myPresenter;

    @Override
    protected int LayoutId() {
        return R.layout.layout_my;
    }

    @Override
    protected void initView(View inflate) {
        gridView = inflate.findViewById(R.id.gv);
    }


    @Override
    protected void initData() {
        myPresenter = new MyPresenter();
        myPresenter.getMyData(this);
    }

    @Override
    public void onMySuccess(ShopBean shopBean) {
        Toast.makeText(getActivity(), "成功", Toast.LENGTH_SHORT).show();
        gridView.setAdapter(new MyAdapter(shopBean.getData()));
    }

    @Override
    public void onMyFailure(Throwable throwable) {
        Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
    }
}
