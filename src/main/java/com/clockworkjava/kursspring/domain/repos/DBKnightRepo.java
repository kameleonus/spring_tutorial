package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;



import java.util.Collection;


public class DBKnightRepo implements KnightRepo{
    @Override
    public void createKnight(String name, int age){
        System.out.println("Baza danych");
    }
    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Baza danych");
        return null;
    }
    @Override
    public Knight getKnight(String name){
        System.out.println("Baza danych");
        return null;
    }
    @Override
    public void removeKnight(String name){
        System.out.println("Baza danych");
    }

    @Override
    @PostConstruct
    public void build(){

    }



}
