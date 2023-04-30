package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Quest;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRepo {
    Random random = new Random();
    List<Quest> questList = new ArrayList<>();

    public void createQuest(String desc){
        questList.add(new Quest(desc));
    }
    public List<Quest> getAll(){
        return questList;
    }
    @PostConstruct
    public void init(){


    }
    public void removeQuest(Quest quest){
        questList.remove(quest);
    }

    @Override
    public String toString() {
        return "QuestRepo{" +
                "questList=" + questList +
                '}';
    }
    @Scheduled(fixedDelayString = "${questCreationDelay}", initialDelay = 3000)
    public void createRandomQuest(){
        List<String> description = new ArrayList<>();
        description.add("Uratuj księżniczkę");
        description.add("Zabij smoka");
        description.add("Odbij zamek");
        description.add("Upoluj hydrę");
        String desc = description.get(random.nextInt(description.size()));
        createQuest(desc);

    }
}
