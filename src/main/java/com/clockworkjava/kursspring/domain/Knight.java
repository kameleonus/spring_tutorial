package com.clockworkjava.kursspring.domain;

public class Knight {

    private String name;

    private int age;

    private Quest quest;


    public Knight() {
        this.name = "Lancelot";
        this.age = 29;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;

    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name + "(" + age + "). Ma za zadanie: " + quest;
    }

    public void setQuest(Quest quest) {
        this.quest=quest;
    }
}
