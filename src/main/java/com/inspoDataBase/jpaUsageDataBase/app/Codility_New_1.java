package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility_New_1 {
    public static void main(String[] args) {

        System.out.println(solution(9, new int[]{1, 2001}));
    }


    public static int solution(int M, int[] A) {
        int N = A.length;


        int minDif = Integer.MAX_VALUE;
        int sumRight = 0;
        int sumLeft = sum(A);

        for (int i = 0; i < N; i++) {
            sumRight = sumRight + A[i];
            sumLeft = sumLeft - A[i];
            minDif = Math.min(minDif, Math.abs(sumLeft - sumRight));
        }
        return minDif;


    }


    public static int sum(int[] A) {

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        return sum;
    }


    public static int[] fillArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i = i + 2) {

            array[i] = 10000;
       /*     if(i>=length){
            array[i+1] = 9999;}*/

        }

        return array;
    }


}
