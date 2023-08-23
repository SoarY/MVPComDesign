package com.soar.network.exception.baseresult;


import com.soar.network.exception.ServerException;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * 拦截服务器返回的错误状态码，剥离ui真正需要的resultData
 */
public class ServerResultFunc<T> implements Function<BaseResult<T>, T> {

    public final static int CODE_SUCCESS = 1;

    @Override
    public T apply(@NonNull BaseResult<T> baseResult) throws Exception {
        if (baseResult.resultCode != CODE_SUCCESS)
            throw new ServerException(baseResult.resultCode, "code: " + baseResult.resultCode);
        //rxjava2  map操作符不在支持null,服务器返回数据为null时候，统一用Object接受.  也可参考https://www.jianshu.com/p/f1957c9c2240
        return baseResult.data == null ? (T) new Object() : baseResult.data;
    }
}
