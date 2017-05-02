package com.inspoDataBase.jpaUsageDataBase.app;

import java.util.stream.IntStream;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility_New_2 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{2, 3, 1, 5}));
    }


    public static int solution(int[] A) {
        int N = A.length;
        int[] b = new int[N + 1];


        for (int i = 0; i < N + 1; i++) {
            b[i] = i + 1;

        }
        int sum1 = IntStream.of(b).sum();
        int sum2 = IntStream.of(A).sum();


        return sum1 - sum2;


    }


}
