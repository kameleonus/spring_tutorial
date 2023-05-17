package com.clockworkjava.kursspring.domain.repos;

import com.clockworkjava.kursspring.domain.Knight;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Optional;


public class DBKnightRepo implements KnightRepo{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public void createKnight(String name, int age){
        Knight knight = new Knight(name,age);
        entityManager.persist(knight);
    }
    @Override
    public Collection<Knight> getAllKnights() {
      return   entityManager.createQuery("from Knight", Knight.class).getResultList();
    }
    @Override
    public Optional<Knight> getKnight(String name){
        Knight knightByName = entityManager.createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }
    @Override
    @Transactional
    public void removeKnight(Integer id){

        entityManager.createQuery("delete from Knight where id=:id").setParameter("id", id).executeUpdate();;
    }

    @Override
    public void build(){

    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        entityManager.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {

        return entityManager.find(Knight.class,id);
    }
    @Override
    @Transactional
    public void upadateKnight(int id, Knight knight){

        entityManager.merge(knight);
    }

}
