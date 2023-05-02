package com.clockworkjava.kursspring.domain;



import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Knight {
    @NotNull
    @Min(2)
    @Max(40)
    private String name;
    @NotNull
    @Range(min=18,max=60, message = "Wiek między 18 a 60")
    private int age;

    private Quest quest;

    private int id;
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Knight() {
        level=1;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        level = 1;

    }

    public Quest getQuest() {
        return quest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
