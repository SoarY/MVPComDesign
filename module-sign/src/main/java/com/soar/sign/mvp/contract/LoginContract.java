package com.soar.sign.mvp.contract;


import com.soar.mvp.base.BaseNaviView;
import com.soar.mvp.base.BasePresenter;
import com.soar.network.bean.request.ServerAddressRequest;
import com.soar.network.retrofit.HttpObserver;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observer;

public interface LoginContract {
    /**
     * V视图层
     */
    interface ILoginView extends BaseNaviView {
        void showToastMsg(String s);
    }

    /**
     * P视图与逻辑处理的连接层
     */
    interface ILoginPresenter extends BasePresenter {
        void getServerAddress(String domain);

        void getKeyState(String phoneNum);
    }

    /**
     * 逻辑处理层
     */
    interface ILoginModel{
        void getServerAddress(ServerAddressRequest requestBean, LifecycleProvider<ActivityEvent> lifecycle, HttpObserver<String> observer);

        void getKeyState(String phoneNum, LifecycleProvider<ActivityEvent> lifecycle, Observer<Integer> observer);
    }
}
