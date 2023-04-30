package com.clockworkjava.kursspring.Services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {
    @Autowired
    KnightRepo repo;
    public List<Knight> getAllKnights(){
     return new ArrayList<>(repo.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        repo.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return  repo.getKnightById(id);
    }
}
