package com.example.springLearn;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class Spring {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanDefinitionRegistry = new DefaultListableBeanFactory();

        BeanFactory container = bindIocCode(beanDefinitionRegistry);

        A aName = (A) container.getBean("aName");

        aName.Asay();

        Object aFactoryBean = container.getBean("aFactoryBeanName");
        System.out.println("aFactoryBean instanceof A = " + (aFactoryBean instanceof A));


        Object aFactoryBeanName = container.getBean("&aFactoryBeanName");
        System.out.println("aFactoryBeanName instanceof AFactoryBean = " + (aFactoryBeanName instanceof AFactoryBean));
    }

    public static BeanFactory bindIocCode(BeanDefinitionRegistry beanDefinitionRegistry){
        AbstractBeanDefinition a = new RootBeanDefinition(A.class);
        AbstractBeanDefinition b = new RootBeanDefinition(B.class);
        AbstractBeanDefinition aFactoryBean = new RootBeanDefinition(AFactoryBean.class);

        // 将bean定义注册到容器中
        beanDefinitionRegistry.registerBeanDefinition("aName",a);
        beanDefinitionRegistry.registerBeanDefinition("bName",b);
        beanDefinitionRegistry.registerBeanDefinition("aFactoryBeanName",aFactoryBean);

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

        mutablePropertyValues.addPropertyValue(new PropertyValue("b",b));
        a.setPropertyValues(mutablePropertyValues);

        return (BeanFactory) beanDefinitionRegistry;

    }
}