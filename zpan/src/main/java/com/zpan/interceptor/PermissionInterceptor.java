package com.zpan.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {

    public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String actionName = actionInvocation.getProxy().getActionName();
        if (actionName.indexOf("login") == -1 && actionName.indexOf("register") == -1 && ActionContext.getContext().getSession().get("user") == null) {
            return "login";
        }
        return actionInvocation.invoke();
    }
}
