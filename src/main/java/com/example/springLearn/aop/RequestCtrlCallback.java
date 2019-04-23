package com.example.springLearn.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liuji
 * @create 2019-04-22 16:38
 */
public class RequestCtrlCallback implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        if (method.getName().equals("request")){
            Object result = null;
            System.out.println("RequestCtrlCallback before........");
            result = methodProxy.invokeSuper(o,objects);
            System.out.println("RequestCtrlCallback after.........");

            return result;
        }
        return null;
    }
}
