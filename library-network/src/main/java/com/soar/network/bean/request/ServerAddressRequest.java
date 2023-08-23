package com.soar.network.bean.request;

public class ServerAddressRequest {

    private String paramDomain;
    private String paramVersion;

    public ServerAddressRequest(String paramDomain, String paramVersion) {
        this.paramDomain = paramDomain;
        this.paramVersion = paramVersion;
    }

}
