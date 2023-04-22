package com.clockworkjava.kursspring.domain;

public class Quest {
    private String desc;

    public Quest(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString(){
        return desc;
    }

}
