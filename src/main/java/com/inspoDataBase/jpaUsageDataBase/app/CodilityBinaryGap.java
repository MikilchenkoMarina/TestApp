package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 13.04.2017.
 */
public class CodilityBinaryGap {
    public static void main(String[] args) {
        int N = 333;


        System.out.println("BG" + solution(333));
    }


    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int longestBinaryGap = 0;

        for (int i = 0; i < binary.length() - 1; i++) {

            if (binary.substring(i, i + 2).equals("10") && binary.substring(i + 2, binary.length()).contains("1")) {
                int tmpBinaryGap = binary.substring(i + 1, binary.indexOf("1", i + 1)).length();
                longestBinaryGap = Math.max(tmpBinaryGap, longestBinaryGap);
            }
        }
        return longestBinaryGap;

    }
}
