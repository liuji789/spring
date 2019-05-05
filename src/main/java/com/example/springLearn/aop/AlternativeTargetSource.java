package com.example.springLearn.aop;

import org.springframework.aop.TargetSource;

/**
 * @author liuji
 * @create 2019-05-05 15:33
 */
public class AlternativeTargetSource implements TargetSource {

    private IRequestable alternativeOne;
    private IRequestable alternativeTwo;
    private int counter;

    public AlternativeTargetSource() {
    }

    public AlternativeTargetSource(IRequestable alternativeOne, IRequestable alternativeTwo) {
        this.alternativeOne = alternativeOne;
        this.alternativeTwo = alternativeTwo;
    }

    @Override
    public Class<?> getTargetClass() {
        return IRequestable.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        try {


            if (counter % 2 == 0) {
                return alternativeTwo;
            } else {
                return alternativeOne;
            }
        } finally {
            counter++;
        }
    }

    @Override
    public void releaseTarget(Object target) throws Exception {

    }
}
