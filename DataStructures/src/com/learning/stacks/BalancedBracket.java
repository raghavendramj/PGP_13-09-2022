package com.learning.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedBracket {

    static boolean areBracketsBalanced(String input) {


        //Base condition
        if (input.length() < 0 || input.length() % 2 != 0) {
            System.out.println("Brackets :- " + input + " are not balanced! ");
            return false;
        }

        List<Character> openingBrackets = Arrays.asList('(', '[', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            //if(openingBrackets.contains(character))
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char peekedValue = stack.peek();
            if (peekedValue == '(' && character == ')' ||
                    peekedValue == '[' && character == ']' ||
                    peekedValue == '{' && character == '}') {
                stack.pop();
            } else {
                //([{]
                //Stack -> ( [ {
                //peekedValue -> {
                // current character -> ]
                System.out.println("Brackets :- " + input + " are not balanced! ");
                return false;
            }
        }

        if (stack.empty()) {
            System.out.println("Brackets :- " + input + " are balanced! ");
            return true;
        } else {
            System.out.println("Brackets :- " + input + " are not balanced! ");
            return false;
        }

    }


    public static void main(String[] args) {
        areBracketsBalanced("()");
        areBracketsBalanced("[]]");
        areBracketsBalanced("([{}])");
        areBracketsBalanced("([{)])");
    }
}
