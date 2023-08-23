package com.soar.sign.activity;

import android.os.Bundle;
import android.os.Handler;

import com.alibaba.android.arouter.launcher.ARouter;
import com.soar.common.router.RoutePath;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private final static long DELAY_MILLIS = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        new Handler().postDelayed(() -> {
            ARouter.getInstance()
                    .build(RoutePath.Sign.SIGN_LOGIN)
                    .navigation();
            finish();
        }, DELAY_MILLIS);
    }
}
