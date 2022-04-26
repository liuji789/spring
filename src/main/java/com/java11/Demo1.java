package com.java11;

/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
public class Demo1 {
    public static void main(String[] args) {
        /*
        * 匿名内部类仅仅在接口和抽象类上使用,作为一种快速的实现方式
        * JAVA9中,普通类也可以借助这种语法形式实现对方法的快速临时的重写
        * */
        Person<String> person=new Person<>(){
            @Override
            public void eat(String s) {
                super.eat(s);
            }
        };
        person.eat("包子");

    }
}
class Person<T>{
    public void eat(T t){
        System.out.println("Person eat");
    }
}