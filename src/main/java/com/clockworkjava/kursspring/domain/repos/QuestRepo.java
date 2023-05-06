package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepo {
    Random random = new Random();
    Map<Integer,Quest> questList= new HashMap<>();


    public void createQuest(String desc){
        int newId = Ids.getNewId(questList.keySet());
        Quest newQuest = new Quest(newId,desc);
        questList.put(newId, newQuest);
    }
    public List<Quest> getAll(){
        return new ArrayList<>(questList.values());
    }
    @PostConstruct
    public void init(){


    }
    public void removeQuest(Quest quest){
        questList.remove(quest.getId());
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
        description.add("Skocz z mostu");
        String desc = description.get(random.nextInt(description.size()));
        createQuest(desc);

    }

    public void update(Quest quest) {
        questList.put(quest.getId(),quest);
    }

    public Quest getQuest(Integer id) {
        return questList.get(id);
    }
}
