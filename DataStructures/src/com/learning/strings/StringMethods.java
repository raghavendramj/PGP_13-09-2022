package com.learning.strings;

import java.util.Collections;
import java.util.PriorityQueue;

public class StringMethods {

    static void charAtDemo(String input) {
        for (int i = 0; i < input.length(); i++) {
            Character eachChar = input.charAt(i);
            System.out.println("Each character :- " + eachChar);
        }
    }

    static void compareToExample(String s1, String s2) {
        System.out.println("Are they same :- " + s1.compareTo(s2));
    }

    static void containsExample(String s1, String s2) {
        System.out.println("s1.contains(s2) :- " + s1.contains(s2));
    }

    static String sortString1(String input) {
        //Arrays.sort(input.toCharArray());
        PriorityQueue<Character> pq = new PriorityQueue<>(); //Min Heap
        PriorityQueue<Character> pqRev = new PriorityQueue<>(Collections.reverseOrder()); //MAX Heap
        PriorityQueue<Character> pqRevSec = new PriorityQueue<>((a, b) -> b - a); //MAX Heap
        for (int i = 0; i < input.length(); i++) {
            pq.add(input.charAt(i));
        }

        String str = new String();
        while (!pq.isEmpty()) {
            str = str + pq.remove();
        }
        System.out.println("Sorted string :- " + str);
        return str;
    }

    static String sortString2(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[j] > chars[i]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.println("Sorted string :- " + new String(chars));
        return new String(chars);
    }

    static void sortString3(String input) {

        int letters[] = new int[26]; //-> filled with 0

        for (char eachChar : input.toCharArray()) {
            //increment the characters -> a -> 1, 2, 3
            letters[eachChar - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            char currentChar = (char) (i + 'a');
            if (letters[i] > 0) {
                //System.out.println(currentChar+ " :- " + letters[i]);
                for (int j = 0; j < letters[i]; j++) {
                    System.out.print(currentChar);
                }
            }
        }
        System.out.println();
    }


    //Time complexity :- O(26 * n) => O(n)
    //Space complexity:- O(1)

    public static void main(String[] args) {
        // a b c d e f g h i j k l m n o p q r s t u v w x y z
        //charAtDemo("GreatLearning");
//        compareToExample("maths", "mathematics"); //s > e -> positive value
//        compareToExample("mathematics", "maths"); //e < s -> negative value
//        compareToExample("physics", "physics"); // 0
//        containsExample("physics", "physics");
//        containsExample("hello how are you", "are ");
//        containsExample("hello how are you", "are  ");
//        containsExample("hello how are you", "Are");
        sortString3("greatlearning");


    }
}
