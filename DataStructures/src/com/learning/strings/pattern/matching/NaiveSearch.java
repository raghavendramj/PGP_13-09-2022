package com.learning.strings.pattern.matching;

public class NaiveSearch {
    static boolean search(String input, String searchPattern) {
        int m = input.length();
        int n = searchPattern.length();

        for (int i = 0; i <= m - n; i++) {
            boolean isMatched = true;
            for (int j = 0; j < n; j++) {
                System.out.println(j+ " searchPattern.charAt(j) -> "+ searchPattern.charAt(j));
                System.out.println((j + i) + " input.charAt(j + i) -> "+ input.charAt(j + i));
                if (searchPattern.charAt(j) != input.charAt(j + i)) {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pat = "AABAACAADAABAAABAA";
        String txt = "DAAB";

        // Function call
        System.out.println("Is pattern getting matched :- " + search(pat, txt));
    }
}
