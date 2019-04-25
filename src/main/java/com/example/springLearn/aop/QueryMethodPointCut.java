package com.example.springLearn.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author liuji
 * @create 2019-04-24 12:04
 * matches 的三个参数的方法，默认不支持，classFilter默认是true
 */
public class QueryMethodPointCut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return method.getName().startsWith("get") &&
                targetClass.getPackage().getName().startsWith("...dao");
    }
}
