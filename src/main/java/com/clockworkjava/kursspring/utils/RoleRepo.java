package com.clockworkjava.kursspring.utils;

import com.clockworkjava.kursspring.domain.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepo {

    @PersistenceContext
    EntityManager em;
    @Transactional
    public void persistRole(Role role){em.persist(role);}
}
