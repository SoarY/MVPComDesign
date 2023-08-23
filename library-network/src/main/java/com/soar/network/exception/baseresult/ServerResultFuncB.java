package com.soar.network.exception.baseresult;


import com.soar.network.exception.ServerException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ServerResultFuncB<T> implements Function<BaseResultB<T>, T> {

    public final static int CODE_SUCCESS = 1;

    @Override
    public T apply(@NonNull BaseResultB<T> baseResult) throws Exception {
        if (baseResult.respCode != CODE_SUCCESS)
            throw new ServerException(baseResult.respCode, baseResult.respDesc);
        return baseResult.respData == null ? (T) new Object() : baseResult.respData;
    }
}
