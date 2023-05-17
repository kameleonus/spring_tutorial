package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Quest;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class QuestRepo {
    @PersistenceContext
    private EntityManager entityManager;
    Random random = new Random();


    @Transactional
    public void createQuest(String desc){

        Quest newQuest = new Quest(desc);

        entityManager.persist(newQuest);
    }
    public List<Quest> getAll(){
       return entityManager.createQuery("from Quest", Quest.class).getResultList();
    }
    @PostConstruct
    public void init(){


    }
    @Transactional
    public void removeQuest(Quest quest){
        entityManager.remove(quest);
    }


    @Scheduled(fixedDelayString = "${questCreationDelay}", initialDelay = 3000)
    @Transactional
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
    @Transactional
    public void update(Quest quest) {
        entityManager.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return entityManager.find(Quest.class,id);
    }
}
