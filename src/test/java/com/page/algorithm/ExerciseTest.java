package com.page.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ExerciseTest {

    @Test
    public void shouldGetRightMedianWhenListLengthIsOddNumber() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        float median = MedianExercise.median(list);

        Assert.assertEquals(2.5, median, 0.0);
    }

    @Test
    public void shouldGetRightMedianWhenListLengthIsEvenNumber() {
        List<Integer> list = Arrays.asList(1, 2, 4);

        float median = MedianExercise.median(list);

        Assert.assertEquals(2, median, 0);
    }
}
