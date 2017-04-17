package com.inspoDataBase.jpaUsageDataBase.app;

import static java.lang.Math.abs;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility333_4 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{9, 4, -3, -10}));
    }


    public static int solution(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        double average = (double) sum / (double) A.length;

        double maxDeviation = 0;
        int indexOfExtreme = -1;

        for (int i = 0; i < A.length; i++) {
            double tmpDeviation = abs((double) A[i] - average);
            if (tmpDeviation > maxDeviation) {
                maxDeviation = tmpDeviation;
                indexOfExtreme = i;
            }

        }

        return indexOfExtreme;
    }
}



