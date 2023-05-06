package com.clockworkjava.kursspring.domain;


import org.springframework.stereotype.Component;

@Component
public class PlayerInfo {

    private int gold=0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
