package com.example.springLearn.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuji
 * @create 2019-04-22 15:43
 */
public class RequestCtrlInvocationHandler implements InvocationHandler {

    private Object target;

    public RequestCtrlInvocationHandler(Object target) {
        this.target = target;
    }

    public RequestCtrlInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("request")){
            Object result = null;
            System.out.println("RequestCtrlInvocationHandler before........");
            result = method.invoke(target,args);
            System.out.println("RequestCtrlInvocationHandler after.........");

            return result;
        }
        return null;
    }
}
