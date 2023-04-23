package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Quest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestRepo {

    List<Quest> questList = new ArrayList<>();

    public void createQuest(String desc){
        questList.add(new Quest(desc));
    }
    public List<Quest> getAll(){
        return questList;
    }
    @PostConstruct
    public void init(){
        createQuest("Uratuj księżniczkę");
        createQuest("Weź udział w turnieju");
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
}
