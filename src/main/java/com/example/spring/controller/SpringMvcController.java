package com.example.spring.controller;

import com.example.spring.valitator.AclassValitator;
import com.example.spring.valitator.BclassValitator;
import com.example.springLearn.ioc.A;
import com.example.springLearn.ioc.B;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import java.util.Map;

/**
 * @author liuji
 * @create 2019-07-11 10:24
 */
public class SpringMvcController {

    public static void main(String[] args) {
        AclassValitator aclassValitator = new AclassValitator(new BclassValitator());

        A a = new A();
        B b = new B();
        B.RecommendBean recommendBean = new B.RecommendBean();
        recommendBean.setId(11);
        b.setRecommend(recommendBean);
        a.setB(b);

        BindException errors = new BindException(a, "aMd");
        ValidationUtils.invokeValidator(aclassValitator,a,errors);

        Map<String, Object> model = errors.getBindingResult().getModel();
        BindingResult bindingResult = (BindingResult) model.get("org.springframework.validation.BindingResult.aMd");

        System.out.println("bindingResult.getAllErrors() = " + bindingResult.getAllErrors());
    }

}
