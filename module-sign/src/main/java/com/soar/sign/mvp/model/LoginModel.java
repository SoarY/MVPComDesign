package com.soar.sign.mvp.model;


import com.soar.network.bean.request.ServerAddressRequest;
import com.soar.network.constant.APIMain;
import com.soar.network.exception.HttpResultFunc;
import com.soar.network.exception.baseresult.ServerResultFuncB;
import com.soar.network.retrofit.HttpObserver;
import com.soar.network.retrofit.RetrofitClient;
import com.soar.network.utils.RxObservableUtils;
import com.soar.sign.mvp.contract.LoginContract;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class LoginModel implements LoginContract.ILoginModel {

    @Override
    public void getServerAddress(ServerAddressRequest requestBean, LifecycleProvider<ActivityEvent> lifecycle, HttpObserver<String> observer) {
        RetrofitClient instance = RetrofitClient.getInstance();
        Observable<String> observable = instance.getApi(APIMain.PARAMETRIC_EXCHANGE_CENTER).getServerAddress(requestBean)
                        .map(new ServerResultFuncB<>())
                        .onErrorResumeNext(new HttpResultFunc<>());
        RxObservableUtils.toSubscribe(observable, observer, lifecycle);
    }

    @Override
    public void getKeyState(String phoneNum, LifecycleProvider<ActivityEvent> lifecycle, Observer<Integer> observer) {
        Observable<Integer> observable = Observable.create(s -> {
            //            int status = SecurityEngine.getInstance().GetMemberStatus(phoneNum);
            //            s.onNext(status);
            s.onComplete();
        });
        RxObservableUtils.toSubscribe(observable, observer, lifecycle);
    }
}
