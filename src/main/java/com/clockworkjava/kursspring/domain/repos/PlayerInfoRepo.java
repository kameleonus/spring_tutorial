package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.PlayerInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerInfoRepo {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void createPlayerInfo(PlayerInfo playerInf){
        entityManager.persist(playerInf);
    }

    public PlayerInfo getFirst() {
        return entityManager.createQuery("from PlayerInfo", PlayerInfo.class).getResultList().get(0);
    }
}
