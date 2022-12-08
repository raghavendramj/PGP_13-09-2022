package com.learning.strings;

public class AreAnangrams {

    static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] intarr1 = new int[256];

        for (Character ch : s1.toCharArray()) {
            intarr1[ch - '0']++;
        }
        int[] intarr2 = new int[256];

        for (Character ch : s2.toCharArray()) {
            intarr2[ch - '0']++;
        }
        for (int i = 0; i < intarr2.length; i++) {
            if (intarr1[i] != intarr2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("Are these strings anagrams :- " + areAnagrams("race", "care"));
        System.out.println("Are these strings anagrams :- " + areAnagramLav("race", "care"));
        System.out.println("Are these strings anagrams :- " + areAnagramLav("raceb", "care"));
    }

    //Needs to be corrected!
    static boolean areAnagramLav(String s1, String s2) {
        int[] letters = new int[256]; //256 -> 0
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
            letters[s2.charAt(i)]--;
        }

        //raghav
        // r-> ++ -- => 1 -> 0
        // a-> ++, ++,  --, -- => 1 -> 2 -> 1 -> 0
        //b-> 1
        //letters[i] -> b == 1, false
        //Entire array should be zero -> Anagarams!
        for (int i = 0; i < 256; i++)
            if (letters[i] != 0)
                return false;
        return true;

    }
}
