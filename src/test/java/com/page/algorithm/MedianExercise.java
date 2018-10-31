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
        List<Integer> mergedList = new ArrayList<Integer>();

        return mergeResidueInSecondListIntoMergedList(
                secondList,
                mergeFirstListIntoMergedList(firstList, secondList, mergedList),
                mergedList);
    }

    public static float medianFromTwoList(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> list = merge(firstList, secondList);
        return median(list);
    }

    private static boolean hasNoValueInList(int secondListIndex, List<Integer> list) {
        return secondListIndex >= list.size();
    }


    private static int mergeFirstListIntoMergedList(List<Integer> firstList, List<Integer> secondList, List<Integer> mergedList) {
        int secondListIndex = 0;
        for (int firstListIndex = 0, size = firstList.size(); firstListIndex < size; firstListIndex++) {
            int valueInFirstList = firstList.get(firstListIndex);

            if (hasNoValueInList(secondListIndex, secondList)) {
                mergedList.add(valueInFirstList);
                continue;
            }

            int valueInSecondList = secondList.get(secondListIndex);
            mergedList.add(valueInFirstList < valueInSecondList ? valueInFirstList : valueInSecondList);
            if (valueInFirstList >= valueInSecondList) {
                secondListIndex++;
                firstListIndex--;
            }
        }
        return secondListIndex;
    }


    private static List<Integer> mergeResidueInSecondListIntoMergedList(List<Integer> secondList, int secondListIndex, List<Integer> mergedList) {
        for (int index = secondListIndex; index < secondList.size(); index++) {
            mergedList.add(secondList.get(index));
        }
        return mergedList;
    }
}
