package com.learning.in.classassignments;

public class FindMissingBrackets {

    public static void main(String[] args) {
        System.out.println("Required parenthesis to make it valid is :- " + minAddToMakeValid("))()(("));
        System.out.println("Required parenthesis to make it valid is :- " + minAddToMakeValid("())"));
        System.out.println("Required parenthesis to make it valid is :- " + minAddToMakeValid("((("));
    }

    public static int minAddToMakeValid(String parenthesis) {

        int closingBrackets = 0, openingBrackets = 0;
        for (char everyChar : parenthesis.toCharArray()) {
            openingBrackets += everyChar == '(' ? 1 : -1;
            if (openingBrackets == -1) {
                openingBrackets++;
                closingBrackets++;
            }
        }
        return openingBrackets + closingBrackets;
    }
}
