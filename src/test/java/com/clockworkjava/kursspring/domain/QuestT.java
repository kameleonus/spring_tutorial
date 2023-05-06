package com.clockworkjava.kursspring.domain;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class QuestT {

    @Test
    public void settingStartedFlagToFalse(){
        Quest quest = new Quest(1,"Testowe");
        quest.setStarted(true);
        assertNotNull(quest.startTime);
    }
    @Test
    public void QuestShouldBeCompletedAfter30Sec(){
        Quest quest = new Quest(1,"Testowe");
        quest.setStarted(true);
        quest.lengthInSec=-60;
        assertTrue(quest.isFinished()) ;
        assertTrue(quest.isFinished()) ;
    }
    @Test
    public void QuestShouldNotBeCompleted(){
        Quest quest = new Quest(1,"Testowe");
        quest.setStarted(true);
        assertFalse(quest.isFinished());
        assertFalse(quest.isFinished());
    }
}
