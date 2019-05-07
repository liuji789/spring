package com.example.springLearn.aop;

/**
 * @author liuji
 * @create 2019-05-05 17:43
 */
public class WithinRequestParam implements IRequestableParan {


    @Override
    public void request(String param1,Integer param2) {
        System.out.println("Aspect param...");
    }
}
