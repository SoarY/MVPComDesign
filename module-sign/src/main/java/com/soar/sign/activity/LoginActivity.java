package com.soar.sign.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.soar.common.router.RoutePath;
import com.soar.common.utils.ToastUtils;
import com.soar.mvp.base.BaseActivity;
import com.soar.sign.R;
import com.soar.sign.R2;
import com.soar.sign.mvp.contract.LoginContract;
import com.soar.sign.mvp.presenter.LoginPresenter;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.navi.NaviLifecycle;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RoutePath.Sign.SIGN_LOGIN)
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {

    @BindView(R2.id.tv_area_code)
    TextView tvAreaCode;
    @BindView(R2.id.et_phone)
    EditText etPhone;
    @BindView(R2.id.et_password)
    EditText etPassword;
    @BindView(R2.id.iv_pswd_eye)
    View ivPswdEye;

    @Override
    public int getContentViewId() {
        return R.layout.sign_activity_login;
    }

    @Override
    protected LoginPresenter bindPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LifecycleProvider<ActivityEvent> getNaviLifecycle() {
        return NaviLifecycle.createActivityLifecycleProvider(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R2.id.tv_area_code, R2.id.iv_pswd_clear, R2.id.iv_pswd_eye, R2.id.tv_forgot_pwd, R2.id.tv_login, R2.id.tv_register})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_login) {
            presenter.getServerAddress("soar");
            presenter.getKeyState("19999000025");
        }
    }

    @Override
    public void showToastMsg(String s) {
        ToastUtils.showToast(s);
    }
}
