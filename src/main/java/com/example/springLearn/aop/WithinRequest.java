package com.example.springLearn.aop;

/**
 * @author liuji
 * @create 2019-05-05 17:43
 */
@JoinpointAnnotation
public class WithinRequest implements IRequestable {
    @Override
    @JoinpointAnnotation1(annotatiaonParam = "annotatiaonParam")
    public void request() {
        System.out.println("Aspect...");
    }
}
