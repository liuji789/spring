package com.example.springLearn.aop;

/**
 * @author liuji
 * @create 2019-04-18 14:09
 */
public class Spring {
    public static void main(String[] args) {

        RequestableImpl requestable = new RequestableImpl();
        ServiceControlRequestableProxy proxy = new ServiceControlRequestableProxy(requestable);

        proxy.request();

    }
}
