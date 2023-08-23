package com.soar.network.retrofit;


import com.soar.network.constant.API;
import com.soar.network.constant.APIMain;
import com.soar.network.ssl.SSLSocketFactoryCompat;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * YONG_
 */
public class RetrofitClient {

    private static volatile RetrofitClient mInstance;
    private HashMap<String, API> apis = new HashMap<>();

    private RetrofitClient() {
        getApi();
    }

    public static RetrofitClient getInstance() {
        if (mInstance == null)
            synchronized (RetrofitClient.class) {
                if (mInstance == null)
                    mInstance = new RetrofitClient();
            }
        return mInstance;
    }

    public API getApi() {
        return getApi(APIMain.PARAMETRIC_EXCHANGE_CENTER);
    }

    public API getApi(String urlMain) {
        if (!apis.containsKey(urlMain)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(urlMain)
                    .client(getOkHttpClient())
                    .build();
            API api = retrofit.create(API.class);
            apis.put(urlMain, api);
        }
        return apis.get(urlMain);
    }

    /**
     * HttpClient: HTTPS
     */
    public static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SSLSocketFactory factory = new SSLSocketFactoryCompat();
            builder.sslSocketFactory(factory);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return builder.build();
    }
}
