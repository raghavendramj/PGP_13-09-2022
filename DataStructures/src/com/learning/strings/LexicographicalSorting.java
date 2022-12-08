package com.learning.strings;

public class LexicographicalSorting {


    static String[] sortStringsLexicographically(String input[]) {

        int n = input.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input[i].compareTo(input[j]) > 0) {
                    System.out.println("input[i] :- " + input[i] + "  input[j] :- " + input[j]);
                    System.out.println("input[i].compareTo(input[j]) -> " + input[i].compareTo(input[j]));

                    String temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }

            }
        }
        for (String each : input) {
            System.out.print(each + " , ");
        }
        System.out.println();

        return input;
    }


    public static void main(String[] args) {

        String names[] = {"John", "Remo", "Mixy", "Julie", "Ronny" };
        sortStringsLexicographically(names);
    }
}
