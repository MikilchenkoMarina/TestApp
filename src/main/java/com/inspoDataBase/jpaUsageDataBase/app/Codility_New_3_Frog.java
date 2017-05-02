package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 17.04.2017.
 */
public class Codility_New_3_Frog {
    public static void main(String[] args) {

        System.out.println(solution(3, 999111321, 7));
    }


    public static int solution(int X, int Y, int D) {
        ;
        return (Y - X) % D > 0 ? (Y - X) / D + 1 : (Y - X) / D;


    }


}
