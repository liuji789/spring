package com.example.spring.valitator;

import com.example.springLearn.ioc.A;
import com.example.springLearn.ioc.B;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author liuji
 * @create 2019-07-11 10:26
 */
public class AclassValitator implements Validator {

    private BclassValitator bclassValitator;

    public AclassValitator(BclassValitator bclassValitator) {
        this.bclassValitator = bclassValitator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ClassUtils.isAssignable(clazz, A.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        A a = (A)target;
        if (a == null){
            errors.reject("a is null");
        }
        ValidationUtils.rejectIfEmpty(errors,"B","B is empty");
        B b = a.getB();
        errors.pushNestedPath("b");
        ValidationUtils.invokeValidator(bclassValitator,b,errors);
        errors.popNestedPath();

    }
}
