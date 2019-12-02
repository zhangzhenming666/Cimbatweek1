package com.example.cimbatweek1.contract;

import com.example.cimbatweek1.model.ShopBean;

/**
 * 时间：2019/12/2
 * 作者：张振明
 * 类的作用：
 */
public class IMyContract {
    public interface IView {
        void onMySuccess(ShopBean shopBean);

        void onMyFailure(Throwable throwable);
    }

    public interface IModelCallback {
        void onMySuccess(ShopBean shopBean);

        void onMyFailure(Throwable throwable);
    }
}
