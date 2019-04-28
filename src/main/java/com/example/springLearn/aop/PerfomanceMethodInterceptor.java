package com.example.springLearn.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;

public class PerfomanceMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("start===>"+ DateUtils.format(new Date(), Locale.CHINESE));
        try {
            return invocation.proceed();
        } finally {
            System.out.println("end===>"+DateUtils.format(new Date(), Locale.CHINESE));
        }


    }
}
