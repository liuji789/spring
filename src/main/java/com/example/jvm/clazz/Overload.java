package com.example.jvm.clazz;

public class Overload {

    public static void sayHello(Object args){
        System.out.println("helllo Object");
    }

    public static void sayHello(int args){
        System.out.println("helllo int");
    }

    public static void sayHello(char args){
        System.out.println("helllo char");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
