package com.clockworkjava.kursspring.Services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repos.KnightRepo;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {
    final static Random rand= new Random();
    @Autowired
    KnightRepo knightRepo;

    QuestRepo questRepo;
    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepo.getAll();
       Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepo.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
       questRepo.removeQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {

        return questRepo.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());

    }
    @Autowired
    public void setQuestRepo(QuestRepo questRepo){
        this.questRepo=questRepo;
    }
    public void update(Quest quest){
        questRepo.update(quest);
    }
    public boolean isQuestCompleted(Quest quest){
        return quest.isFinished();
    }
}
