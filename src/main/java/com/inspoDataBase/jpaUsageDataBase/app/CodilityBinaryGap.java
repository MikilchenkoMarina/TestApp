package com.inspoDataBase.jpaUsageDataBase.app;

/**
 * @author mmikilchenko on 13.04.2017.
 */
public class CodilityBinaryGap {
    public static void main(String[] args) {
        int N = 9;
        String binary = Integer.toBinaryString(N);
        int bin = 0;
        for (int i = 0; i < binary.length(); i++) {

            if (binary.substring(i, i + 2).equals("10") && binary.substring(i + 2, binary.length()).contains("1")) {

            }
        }
    }
}
