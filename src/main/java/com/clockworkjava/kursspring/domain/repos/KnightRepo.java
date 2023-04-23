package com.clockworkjava.kursspring.domain.repos;


import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//Reopzytorium knightów
@Repository
public class KnightRepo {



    Map<String, Knight> knights= new HashMap<>();



    public void createKnight(String name,int age){
        knights.put(name,new Knight(name,age));
    }
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }
    public Knight getKnight(String name){
        return knights.get(name);
    }
    public void removeKnight(String name){
       knights.remove(name);
    }
   public KnightRepo(){}


    @PostConstruct
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);
    }

    @Override
    public String toString() {
        return "KnightRepo{" +
                "knights=" + knights +
                '}';
    }
}
