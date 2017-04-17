package com.inspoDataBase.jpaUsageDataBase.app;

import static java.lang.Math.abs;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility333_2 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{8, 24, 3, 20, 1, 17}));
    }


    public static int solution(int[] A) {
        int minDistance = 1000000;

        for (int i = 0; i < A.length; i++) {


            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    int tmpDistance = abs(A[i] - A[j]);
                    if (abs(tmpDistance) < abs(minDistance)) {
                        minDistance = tmpDistance;
                    }
                }
            }
        }

        return minDistance;
    }
}



