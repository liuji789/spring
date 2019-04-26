package com.example.spring.service;

import org.springframework.stereotype.Service;

@Service
public class AService {

    private Integer a ;

    public Integer getA(String thread) throws Exception{
        a = new Integer(thread);
        if ("1".equals(thread)){
            Thread.sleep(5000);
        }
        return a;
    }
}
