package com.page.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExerciseTest {

    @Test
    public void shouldGetRightMedianWhenListLengthIsOddNumber() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        float median = MedianExercise.median(list);

        assertEquals(2.5, median, 0.0);
    }

    @Test
    public void shouldGetRightMedianWhenListLengthIsEvenNumber() {
        List<Integer> list = Arrays.asList(1, 2, 4);

        float median = MedianExercise.median(list);

        assertEquals(2, median, 0);
    }

    @Test
    public void shouldReturnTheMaximumValueBetweenTwoArrayList() {
        List<Integer> firstList = Arrays.asList(1, 3);
        List<Integer> secondList = Arrays.asList(2, 4);

        int max = MedianExercise.getMaximum(firstList, secondList);

        assertEquals(4, max);
    }

    @Test
    public void shouldMergeTwoListIntoOne() {
        List<Integer> firstList = Arrays.asList(1, 3);
        List<Integer> secondList = Arrays.asList(2, 4);

        List<Integer> mergedList = MedianExercise.merge(firstList, secondList);

        assertEquals(Arrays.asList(1, 2, 3, 4), mergedList);
    }

    @Test
    public void shouldMergeTwoListIntoOneWhenFistListIsEmpty() {
        List<Integer> firstList = Collections.emptyList();
        List<Integer> secondList = Arrays.asList(2, 4);

        List<Integer> mergedList = MedianExercise.merge(firstList, secondList);

        assertEquals(Arrays.asList(2, 4), mergedList);
    }

    @Test
    public void shouldMergeTwoListIntoOneWhenSecondListIsEmpty() {
        List<Integer> firstList = Arrays.asList(2, 4);
        List<Integer> secondList = Collections.emptyList();

        List<Integer> mergedList = MedianExercise.merge(firstList, secondList);

        assertEquals(Arrays.asList(2, 4), mergedList);
    }

    @Test
    public void shouldMergeTwoListIntoOneWhenHaveSameItemInThoseList() {
        List<Integer> firstList = Arrays.asList(1, 2);
        List<Integer> secondList = Arrays.asList(1, 2);

        List<Integer> mergedList = MedianExercise.merge(firstList, secondList);

        assertEquals(Arrays.asList(1, 1, 2, 2), mergedList);
    }

    @Test
    public void shouldGetRightMedianFromTwoList() {
        List<Integer> list = Arrays.asList(1, 999, 1001, 10000);
        List<Integer> firstList = new ArrayList<Integer>();
        List<Integer> secondList = new ArrayList<Integer>();
        for (int value : list) {
            int diceValue = (int) (Math.random() * 10) % 2;
            if (diceValue == 0) {
                firstList.add(value);
            } else {
                secondList.add(value);
            }
        }

        float median = MedianExercise.medianFromTwoList(firstList, secondList);

        assertEquals(1000, median, 0);
    }


}
