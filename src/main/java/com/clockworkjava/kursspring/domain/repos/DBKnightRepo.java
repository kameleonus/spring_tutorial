package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.annotation.PostConstruct;



import java.util.Collection;
import java.util.Optional;


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
    public Optional<Knight> getKnight(String name){
        System.out.println("Baza danych");
        return null;
    }
    @Override
    public void removeKnight(Integer id){
        System.out.println("Baza danych");
    }

    @Override
    @PostConstruct
    public void build(){

    }

    @Override
    public void createKnight(Knight knight) {

    }

    @Override
    public Knight getKnightById(Integer id) {
        return null;
    }
    @Override
    public void upadateKnight(int id, Knight knight){
        System.out.println("bywa");
    }

}
