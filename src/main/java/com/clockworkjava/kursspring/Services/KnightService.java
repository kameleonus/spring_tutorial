package com.clockworkjava.kursspring.Services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInfo;
import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {
    @Autowired
    KnightRepo repo;
    @Autowired
    PlayerInfo playerInfo;
   
    public List<Knight> getAllKnights(){
     return new ArrayList<>(repo.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        repo.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return  repo.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        repo.removeKnight(id);
    }

    public void updateKnight(Knight knight) {
        repo.upadateKnight(knight.getId(),knight);
    }

    public int collectRewards() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isFinished();
            } else {
                return false;
            }
        };
        int sum= repo.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward()).sum();
        repo.getAllKnights().stream().filter(knightPredicate).forEach(knight -> knight.setQuest(null));
        return sum;
    }
    public void getMyGold(){
        List<Knight> allKnights=getAllKnights();
        allKnights.forEach(knight ->
        {if(knight.getQuest()!=null)
        { knight.getQuest().isFinished();}});
        int currentGold = playerInfo.getGold();
        playerInfo.setGold(currentGold + collectRewards());
    }
}
