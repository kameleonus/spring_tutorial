package com.clockworkjava.kursspring.utils;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdsT {
    @Test
    public void testEmptySet(){
        Integer result=Ids.getNewId(Collections.emptySet());
        assertEquals(0,result);
    }
    @Test
    public void testGenerateNewId(){
        Set<Integer> smaple = new HashSet<>();
        smaple.add(4);
        smaple.add(5);
        smaple.add(6);
        int result = Ids.getNewId(smaple);
        assertEquals(7,result);
    }
}
