package com.soar.network.exception.baseresult;

/**
 * YONG_
 * 用户中心 实体基类
 */
public class BaseResultA<T> {

    public int code;

    public String message;

    public String data_type;

    public T data;
}
