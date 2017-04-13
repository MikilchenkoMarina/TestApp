package com.inspoDataBase.jpaUsageDataBase.app;

import java.util.Arrays;
import java.util.Random;

/**
 * @author mmikilchenko on 13.04.2017.
 */
public class CodilityTest {


    public static int[] fillArray() {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            array[i] = rand.nextInt(11);

        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 1, 2, -3, 5};

        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int sumBefore = 0;
            int sumAfter = 0;

            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                sumBefore = sumBefore + array[leftIndex];
            }

            for (int rightIndex = i + 1; rightIndex < array.length; rightIndex++) {
                sumAfter = sumAfter + array[rightIndex];
            }

            if (sumBefore == sumAfter) {
                System.out.println("EQUILIBRUM IST " + i);

                System.out.println("Binary" + Integer.toBinaryString(+9));
            }

        }
    }


}
