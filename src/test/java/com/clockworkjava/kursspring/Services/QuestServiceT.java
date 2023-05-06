package com.clockworkjava.kursspring.Services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repos.QuestRepo;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;



import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestServiceT {
    @Mock
    QuestRepo questRepoMock;

    @Test
    public void returnNotStartedQuests() {
        List<Quest> questList = new ArrayList<>();
        Quest q1 = new Quest(1,"some");
        Quest q2 = new Quest(2,"some more");
        Quest q3 = new Quest(3,"some more more");
        q2.setStarted(true);
        questList.add(q1);
        questList.add(q2);
        questList.add(q3);
        when(questRepoMock.getAll()).thenReturn(questList);
        QuestService qs = new QuestService();
        qs.setQuestRepo(questRepoMock);
        List<Quest> allNotStartedQuests = qs.getAllNotStartedQuests();
        assertEquals(  2, allNotStartedQuests.size());
        assertThat(allNotStartedQuests,containsInAnyOrder(q1,q3));
    }

}

