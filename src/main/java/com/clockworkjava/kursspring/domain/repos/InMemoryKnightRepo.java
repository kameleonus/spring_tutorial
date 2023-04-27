package com.clockworkjava.kursspring.domain.repos;


import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Reopzytorium knightów

public class InMemoryKnightRepo implements KnightRepo {



    Map<String, Knight> knights= new HashMap<>();


    @Override
    public void createKnight(String name, int age){
        knights.put(name,new Knight(name,age));
    }
    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }
    @Override
    public Knight getKnight(String name){
        return knights.get(name);
    }
    @Override
    public void removeKnight(String name){
       knights.remove(name);
    }
   public InMemoryKnightRepo(){}

    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepo{" +
                "knights=" + knights +
                '}';
    }

}
