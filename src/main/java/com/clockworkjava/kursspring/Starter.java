package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.Services.QuestService;

import com.clockworkjava.kursspring.domain.PlayerInfo;
import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import com.clockworkjava.kursspring.domain.repos.PlayerInfoRepo;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
import com.clockworkjava.kursspring.domain.Role;
import com.clockworkjava.kursspring.utils.RoleRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepo knightRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PlayerInfoRepo playerInfoRepo;
    @Autowired
    QuestRepo questRepo;
    @Autowired
    QuestService questService;
    @Override
    @Transactional
   public void run(String... args) throws Exception {


        questRepo.createRandomQuest();
        questRepo.createRandomQuest();
        knightRepo.createKnight("Artur",23);
        PlayerInfo playerInfo1 = new PlayerInfo("user1","user1");
        playerInfoRepo.createPlayerInfo(playerInfo1);
        PlayerInfo playerInfo2 = new PlayerInfo("user2","user2");
        playerInfoRepo.createPlayerInfo(playerInfo2);
        PlayerInfo adminInfo = new PlayerInfo("admin","admin");
        playerInfoRepo.createPlayerInfo(adminInfo);

        Role user1Role = new Role("user1","USER");
        Role user2Role = new Role("user2","USER");
        Role adminRole = new Role("admin","ADMIN");
        roleRepo.persistRole(user1Role);
        roleRepo.persistRole(user2Role);
        roleRepo.persistRole(adminRole);
        questService.assignRandomQuest("Artur");
   }


}
