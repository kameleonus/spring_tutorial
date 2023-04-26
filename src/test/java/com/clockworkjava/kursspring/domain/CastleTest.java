package com.clockworkjava.kursspring.domain;

import com.clockworkjava.kursspring.domain.Castle;
import com.clockworkjava.kursspring.domain.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleTest {
    @Test
    public void castleToString(){
        Quest quest = new Quest();
        Knight knight= new Knight();
        knight.setQuest(quest);
        Castle castle = new Castle(knight,"Wesst Watch");
        String exept ="Znajduje się zamek tu o nazwie: Wesst Watch sRycerz o imienie Lancelot (26). Zadanie: .Save " +
                "the kong";
        assertEquals(exept,castle.toString());
    }
}
