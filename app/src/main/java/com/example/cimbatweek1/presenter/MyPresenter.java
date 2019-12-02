package com.example.cimbatweek1.presenter;

import com.example.cimbatweek1.contract.IMyContract;
import com.example.cimbatweek1.model.MyModel;
import com.example.cimbatweek1.model.ShopBean;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class MyPresenter {
    private MyModel myModel;

    public void getMyData(final IMyContract.IView iView) {
        myModel = new MyModel();
        myModel.getMyData(new IMyContract.IModelCallback() {
            @Override
            public void onMySuccess(ShopBean shopBean) {
                iView.onMySuccess(shopBean);
            }

            @Override
            public void onMyFailure(Throwable throwable) {
                iView.onMyFailure(throwable);
            }
        });
    }
}
