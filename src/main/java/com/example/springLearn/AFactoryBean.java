package com.example.springLearn;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author liuji
 * @create 2019-04-17 16:44
 */
public class AFactoryBean implements FactoryBean<A> {
    @Override
    public A getObject() throws Exception {
        return new A();
    }

    @Override
    public Class<?> getObjectType() {
        return A.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
