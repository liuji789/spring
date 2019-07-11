package com.example.spring.valitator;

import com.example.springLearn.ioc.B;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author liuji
 * @create 2019-07-11 10:31
 */
public class BclassValitator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ClassUtils.isAssignable(clazz, B.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        B b = (B) target;
        B.RecommendBean recommend = b.getRecommend();
        if (recommend.getId() > 10){
            errors.rejectValue("recommend","recommend id is out");
        }
    }
}
