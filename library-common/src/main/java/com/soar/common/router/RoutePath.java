package com.soar.common.router;

/**
 * 用于组件开发中
 * 在这里注册添加路由路径，需要清楚的写好注释，标明功能界面
 */
public interface RoutePath {

    /**
     * 身份验证组件
     */
    interface Sign {
        String SIGN = "/sign";
        //登录界面
        String SIGN_LOGIN = SIGN + "/login";
    }

    /**
     * 用户组件
     */
    interface User {
        String USER = "/user";
        //登录界面
        String USER_USERDETAIL = USER + "/userDetail";
    }

}
