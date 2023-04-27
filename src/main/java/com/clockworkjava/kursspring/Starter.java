package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.Services.QuestService;
import com.clockworkjava.kursspring.domain.repos.InMemoryKnightRepo;

import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        System.out.println(knightRepo);
        questRepo.createRandomQuest();
        System.out.println(questRepo);
        questRepo.createRandomQuest();
        System.out.println(questRepo);

        questService.assignRandomQuest("Lancelot");
        questService.assignRandomQuest("Percival");
   }


}
