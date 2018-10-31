package com.page.algorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
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


    public static int getMaximum(List<Integer> firstList, List<Integer> secondList) {
        int maxInFirstList = firstList.get(firstList.size() - 1);
        int maxInSecondList = secondList.get(secondList.size() - 1);
        return maxInFirstList > maxInSecondList ? maxInFirstList : maxInSecondList;
    }


    public static List<Integer> merge(List<Integer> firstList, List<Integer> secondList) {
        int secondListIndex = 0;
        int secondListSize = secondList.size();

        List<Integer> mergedList = new ArrayList<Integer>();
        for (int index = 0, size = firstList.size(); index < size; index++) {
            int valueInFirstList = firstList.get(index);
            if (secondListIndex >= secondListSize) {
                mergedList.add(valueInFirstList);
            } else {
                int valueInSecondList = secondList.get(secondListIndex);
                if (valueInFirstList < valueInSecondList) {
                    mergedList.add(valueInFirstList);
                } else {
                    mergedList.add(valueInSecondList);
                    secondListIndex++;
                    index--;
                }
            }
        }

        for (int index = secondListIndex; index < secondListSize; index++) {
            mergedList.add(secondList.get(index));
        }

        return mergedList;
    }
}
