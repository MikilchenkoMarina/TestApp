package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility333_3 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{-8, 4, 0, 5, -3, 6}));
    }


    public static int solution(int[] A) {
        int maxSumDistance = 0;

        for (int i = 0; i < A.length; i++) {
            int tmpSumDistance;
            for (int j = 0; j < A.length; j++) {
                if (i > j) {
                    tmpSumDistance = A[i] + A[j] + (i - j);
                } else {
                    tmpSumDistance = A[i] + A[j] + (j - i);
                }
                if (maxSumDistance < tmpSumDistance) {
                    maxSumDistance = tmpSumDistance;
                }
            }
        }

        return maxSumDistance;
    }
}



