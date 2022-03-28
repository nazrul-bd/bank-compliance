package com.selise;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = {Test.class})
public class Test {

    @org.junit.jupiter.api.Test
    public void testSumOfTwoElementOfArrayEqualsToTarget() {

        List<Integer> numbers = Arrays.asList(-1, 2, 3, 4, 5, 6, 7, 8, 5, 2);
        Integer targetNumber = 12;

        System.out.println("Numbers Less then Zero: " + numbers.parallelStream().filter(n -> n < 0).collect(Collectors.toList()));
        for (int i = 0; i < numbers.size(); i++) {

            for (int j = i + 1; j < numbers.size(); j++) {

                Integer tempSum = numbers.get(i) + numbers.get(j);
                if (tempSum == targetNumber) {
                    System.out.println("Target:" + targetNumber + " is equal to sum of two element of array: " + numbers.get(i) + " & " + numbers.get(j));
                    return;
                }
            }
        }
    }
}
