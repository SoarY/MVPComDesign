package com.soar.network.exception.baseresult;


import com.soar.network.exception.ServerException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class ServerResultFuncA<T> implements Function<BaseResultA<T>, T> {

    public final static int CODE_SUCCESS = 0;

    @Override
    public T apply(@NonNull BaseResultA<T> baseResult) throws Exception {
        if (baseResult.code != CODE_SUCCESS)
            throw new ServerException(baseResult.code, baseResult.message);
        return baseResult.data == null ? (T) new Object() : baseResult.data;
    }
}
