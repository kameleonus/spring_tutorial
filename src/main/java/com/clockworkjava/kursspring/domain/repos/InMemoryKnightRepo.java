package com.clockworkjava.kursspring.domain.repos;


import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.utils.Ids;
import jakarta.annotation.PostConstruct;

import java.util.*;

//Reopzytorium knightów

public class InMemoryKnightRepo implements KnightRepo {



    Map<Integer, Knight> knights= new HashMap<>();

    @Override
    public void createKnight(String name, int age){
        Knight newknight = new Knight(name,age);
        newknight.setId(Ids.getNewId(knights.keySet()));
        knights.put(newknight.getId(), newknight);
    }


    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }
    @Override
    public Optional<Knight> getKnight(String name){
        Optional<Knight> byName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();

        return byName;
    }
    @Override
    public void removeKnight(Integer id){

        knights.remove(id);
    }
   public InMemoryKnightRepo(){}

    @Override
    @PostConstruct
    public void build(){
        createKnight("Lancelot",29);
        createKnight("Percival",25);

    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Ids.getNewId(knights.keySet()));
        knights.put(knight.getId(),knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepo{" +
                "knights=" + knights +
                '}';
    }

}
