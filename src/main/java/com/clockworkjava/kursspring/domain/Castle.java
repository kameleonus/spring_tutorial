package com.clockworkjava.kursspring.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Castle {
    private String name="West Watch";
    public Castle() {

    }
    @PostConstruct
    public void build(){
        System.out.println("Wybudowano zamek: "+name);
    }
    @PreDestroy
    public void  tearDown(){
        System.out.println("Zaraz wyburzymy zamek: "+name);
    }
}
