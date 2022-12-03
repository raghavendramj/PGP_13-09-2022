package com.learning.strings;

public class StringExample {

    public static void main(String[] args) {

        String s1 = "ani";
        String s2 = "ruth";
        System.out.println("S1's address :- "+ s1.hashCode());
        System.out.println("S2's address :- "+ s2.hashCode());

        s1 = "aniruth";
        s2 = "aniruth";
        System.out.println("S1's address :- "+ s1.hashCode());
        System.out.println("S2's address :- "+ s2.hashCode());

        String s3 = "Raghav";
    }
}
