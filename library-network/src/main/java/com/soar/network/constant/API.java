package com.soar.network.constant;


import com.soar.network.bean.request.ServerAddressRequest;
import com.soar.network.exception.baseresult.BaseResultB;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * YONG_
 */
public interface API {

    /**
     * 参数中心获取服务器地址
     */
    @POST("restfulApi/ParamEx/getVoipAddrByDomain")
    Observable<BaseResultB<String>> getServerAddress(@Body ServerAddressRequest bean);
}
