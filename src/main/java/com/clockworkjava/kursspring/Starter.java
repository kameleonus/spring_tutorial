package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.Quest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Quest saveThePrincess = new Quest("Uratuja księżniczkę");
        Quest killTheDragon = new Quest("Zabij smoka");
        Knight lancelot = new Knight("Lancelot",23,saveThePrincess);
        System.out.println(lancelot);
        Knight percival = new Knight("Percival",28);
        System.out.println(percival);
        percival.setQuest(killTheDragon);
        System.out.println(percival);
    }
}
