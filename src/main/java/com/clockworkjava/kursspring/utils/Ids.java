package com.clockworkjava.kursspring.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {
   static public int getNewId(Set<Integer> keysoFar) {
        if (keysoFar.isEmpty()) {
            return 0;
        } else {
            Integer integer = keysoFar.stream().max(Comparator.naturalOrder()).get();
            return (integer +1);
        }
    }
}
