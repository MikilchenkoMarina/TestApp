package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility333 {
    public static void main(String[] args) {

        System.out.println(solution(9, fillArray(200000)));
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


    public static int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];

        for (int i = 0; i <= M; i++)
     /*       if (Arrays.asList(A).contains(i)) {*/
            count[i] = 0;
/*            } else {
                count[i] = -1;
            }*/
        int maxOccurence = 1;
        int index = -1;

        for (int i = 0; i < N; i++) {
            if (A[i] <= M) {
                if (count[A[i]] > 0) {
                    int tmp = count[A[i]];
                    if (tmp > maxOccurence) {
                        maxOccurence = tmp;
                        index = i;
                    }
                    count[A[i]] = tmp + 1;
                } else {
                    count[A[i]] = 1;
                }
            }
        }
        return A[index];
    }


}
