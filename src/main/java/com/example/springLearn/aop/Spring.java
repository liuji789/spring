package com.example.springLearn.aop;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @author liuji
 * @create 2019-04-18 14:09
 */
public class Spring {
    public static void main(String[] args) {

        RequestableImpl requestable = new RequestableImpl();
        ServiceControlRequestableProxy proxy = new ServiceControlRequestableProxy(requestable);

        proxy.request();

        Class<?>[] interfaces = requestable.getClass().getInterfaces();

        //动态生成动态代理类对象
        //第一个参数：类加载器对象
        //第二个参数：目标对象所实现的接口
        //第个参数：告知代理类使用哪个代理模板，即代理处理器
        IRequestable iRequestable=(IRequestable)Proxy.newProxyInstance(Spring.class.getClassLoader(), interfaces, new RequestCtrlInvocationHandler(new RequestableImpl()));

        iRequestable.request();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Requestable.class);
        enhancer.setCallback(new RequestCtrlCallback());

        Requestable requestable1 = (Requestable) enhancer.create();
        requestable1.request();

    }
}
