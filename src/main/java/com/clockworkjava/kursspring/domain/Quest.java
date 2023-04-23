package com.clockworkjava.kursspring.domain;

import org.springframework.stereotype.Component;

@Component
public class Quest {
    private String desc;

    public Quest() {
        this.desc = "Save the kong";
    }
    @Override
    public String toString(){
        return desc;
    }

}
