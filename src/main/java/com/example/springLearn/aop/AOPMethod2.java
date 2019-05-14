package com.example.springLearn.aop;

import org.springframework.aop.framework.AopContext;

public class AOPMethod2 {

    public void method1() {

        ((AOPMethod2) AopContext.currentProxy()).method2();
        System.out.println("\"method1();\" = " + "method1();");
    }

    public void method2() {
        System.out.println("\"method2();\" = " + "method2();");
    }
}
