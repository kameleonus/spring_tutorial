package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Knight;



import java.util.Collection;
import java.util.Optional;

public interface KnightRepo {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void removeKnight(Integer id);

    void build();


    void createKnight(Knight knight);
    Knight getKnightById(Integer id);

    default void upadateKnight(int id, Knight knight){
        System.out.println("bywa");
    }
}
