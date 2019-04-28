package com.example.spring.service;

import com.example.spring.bean.AAAA;
import org.springframework.stereotype.Service;

@Service("aService")
//@Scope("prototype")
public class AService {

    private AAAA aaaa ;

    public AAAA  getA(String thread) throws Exception{


        aaaa = new AAAA();
        aaaa.setA(thread);

        if ("1".equals(thread)){
            Thread.sleep(5000);
        }


        return aaaa;
    }
}
