package com.example.jvm.clazz;

public class StaticResolution {

    public static void sayHello(){
        System.out.println("hello world");
    }

    public final void sayHi(){
        System.out.println("hi world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
        new StaticResolution().sayHi();
    }

}
