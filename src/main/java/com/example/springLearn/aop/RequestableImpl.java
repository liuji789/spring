package com.example.springLearn.aop;

/**
 * @author liuji
 * @create 2019-04-18 14:00
 */
public class RequestableImpl implements IRequestable {
    @Override
    public void request() {
        System.out.println("request process in RequestableImpl ");
    }
}
