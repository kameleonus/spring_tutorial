package com.clockworkjava.kursspring.domain;


import java.time.LocalDateTime;

public class Quest {
    private int id;
    private String desc;

    private int reward=100;
    protected int lengthInSec = 10;
    private boolean started=false;
    private boolean finished=false;

    protected LocalDateTime startTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLength() {
        return lengthInSec;
    }

    public void setLength(int length) {
        this.lengthInSec = length;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started){
            this.startTime=LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isFinished() {
        if (!this.finished) {

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime localDateTime = this.startTime.plusSeconds(this.lengthInSec);
            boolean isAfter = now.isAfter(localDateTime);
            if (isAfter) {
                this.finished = true;
            }
        }
        return this.finished;
    }

    public void setFinished(boolean finished) {
            this.finished=finished;
    }

    public Quest(int id,String desc){
        this.id=id;
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }

}
