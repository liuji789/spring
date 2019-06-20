package com.example.springLearn.data;


/**
 * 模板方法
 */
public abstract class Vehicle {

    public final void drive(){
        startTheEngine();
        stepTow();
        stepThree();
    }

    protected abstract void stepThree();

    private void startTheEngine(){

    }

    private void stepTow(){

    }
}
