package com.example.spring.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SpringTask {

    @Scheduled(cron = "*/5 * * * * *")
    public void excute(){
        System.out.println("true = " + true);
    }


}
