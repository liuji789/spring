package com.example.springLearn.ioc;

/**
 * @author liuji
 * @create 2019-04-17 16:43
 */
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void Asay(){
        System.out.println("b = " + b);
    }
}
