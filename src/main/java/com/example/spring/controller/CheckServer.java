package com.example.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuji
 * @create 2019-04-17 16:31
 */
@RestController
public class CheckServer {

    @RequestMapping("/check")
    public Map<String,Object> spring(){
        HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("code","1");
        returnMap.put("msg","11111111");
        return returnMap;
    }

}
