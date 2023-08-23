package com.soar;

import android.app.Application;

import com.soar.common.imp.IModuleInit;

/**
 * Application 时初始化操作(反射)
 */
public class SignModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
