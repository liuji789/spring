package com.example.springLearn.aop;

/**
 * @author liuji
 * @create 2019-04-18 14:02
 */
public class ServiceControlRequestableProxy implements IRequestable {

    private IRequestable requestable;
    @Override
    public void request() {
        System.out.println("ServiceControlRequestableProxy before");
        requestable.request();
        System.out.println("ServiceControlRequestableProxy after");
    }

    public ServiceControlRequestableProxy() {
    }

    public ServiceControlRequestableProxy(IRequestable requestable) {
        this.requestable = requestable;
    }
}
