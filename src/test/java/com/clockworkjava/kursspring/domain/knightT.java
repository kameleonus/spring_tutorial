package com.clockworkjava.kursspring.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class knightT {
    @Test
    public void testQuestMarkAsStartred(){
        Knight knight = new Knight("Janusz",21);
        Quest quest = new Quest(1,"Testowe");
        knight.setQuest(quest);
        assertTrue(knight.getQuest().isStarted());
    }
}
