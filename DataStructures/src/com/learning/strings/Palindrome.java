package com.learning.strings;

public class Palindrome {

    //raghav  -> false
    //dewed, radar, wow, mom, dad, madam, gadag, level, kayak, pop, noon, refer, rotator -> true


    static boolean isPlaindrome(String input) {
        int n = input.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    static boolean isPalindrome(String txt) {
        String rev = "";
        if (txt.length() <= 1) return true;
        for (int i = txt.length() - 1; i >= 0; i--) {
            rev += txt.charAt(i);
        }
        if (rev.equals(txt)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println("Is palindrome :- " + isPlaindrome("madam"));
        System.out.println("Is palindrome :- " + isPlaindrome("madamemadame"));
        System.out.println("Is palindrome :- " + isPlaindrome("gadag"));

    }
}
