package com.page.algorithm;

import java.math.BigDecimal;
import java.util.List;

public class MedianExercise {
    public static float median(List<Integer> list) {
        int size = list.size();

        return size % 2 != 0 ?
                list.get((size - 1) / 2) :
                new BigDecimal(list.get(size / 2 - 1) + list.get(size / 2))
                        .divide(new BigDecimal(2), 1, BigDecimal.ROUND_CEILING)
                        .floatValue();
    }
}
