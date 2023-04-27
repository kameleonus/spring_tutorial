package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Knight;


import java.util.Collection;

public interface KnightRepo {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void removeKnight(String name);

    void build();
}
