package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.Services.QuestService;

import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
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
    QuestRepo questRepo;
    @Autowired
    QuestService questService;
    @Override
   public void run(String... args) throws Exception {


        questRepo.createRandomQuest();
        questRepo.createRandomQuest();
        questService.assignRandomQuest("Lancelot");

   }


}
