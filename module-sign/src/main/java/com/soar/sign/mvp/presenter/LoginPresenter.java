package com.soar.sign.mvp.presenter;


import com.soar.common.base.BaseApplication;
import com.soar.network.bean.request.ServerAddressRequest;
import com.soar.network.exception.APIException;
import com.soar.network.retrofit.HttpObserver;
import com.soar.sign.R;
import com.soar.sign.mvp.contract.LoginContract;
import com.soar.sign.mvp.model.LoginModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenter implements LoginContract.ILoginPresenter {
    private LoginContract.ILoginView mView;
    private LoginContract.ILoginModel mLoginModel;

    public LoginPresenter(LoginContract.ILoginView mView) {
        this.mView = mView;
        mLoginModel = new LoginModel();
    }

    @Override
    public void getServerAddress(String domain) {
        getServerAddress(new ServerAddressRequest(domain, "1"));
    }

    public void getServerAddress(ServerAddressRequest requestBean) {
        mLoginModel.getServerAddress(requestBean, mView.getNaviLifecycle(), new HttpObserver<String>() {

            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String data) {
            }

            @Override
            public void onError(APIException ex) {
                mView.showToastMsg(ex.getDisplayMessage());
            }

            @Override
            public void onComplete() {
            }
        });
    }

    /**
     * 检测私钥状态
     *
     * @param phoneNum 手机号
     */
    @Override
    public void getKeyState(String phoneNum) {
        mLoginModel.getKeyState(phoneNum, mView.getNaviLifecycle(), new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer status) {
                switch (status) {
                    case 0:
                    case 5://用户状态正常
                        //                        mView.showTipsDialog();
                        break;
                    case 1:
                    case 3:
                        //                        mView.toRegisterActivity();
                        break;
                    case 2:
                        mView.showToastMsg(BaseApplication.getContext().getString(R.string.sign_ex_user_have_been_disabled));
                    case 4:
                        mView.showToastMsg(BaseApplication.getContext().getString(R.string.sign_ex_user_overdue));
                    default:
                        mView.showToastMsg(BaseApplication.getContext().getString(R.string.sign_ex_user_error));
                }
            }

            @Override
            public void onError(Throwable e) {
                mView.showToastMsg(e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        });
    }

    /**
     * 当页面销毁的时候,需要把View=null(避免内存泄漏)
     */
    @Override
    public void onDestroy() {
        mView = null;
    }
}
