package com.clockworkjava.kursspring.domain;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:castle.properties")
public class Castle {
    @Value("${my.castle.name:West Watch}")
    private String name;
    @Autowired
    Knight knight;
    public Castle(Knight knight) {
        this.knight=knight;
    }
    Castle(Knight knight,String name){
        this.knight=knight;
        this.name=name;
    }

    @PostConstruct
    public void build(){
        System.out.println("Wybudowano zamek: "+name);
    }
    @PreDestroy
    public void  tearDown(){
        System.out.println("Zaraz wyburzymy zamek: "+name);
    }
    @Override
    public String toString(){
        return "Znajduje się zamek tu o nazwie: "+this.name+" s"+knight.toString();
    }

}
