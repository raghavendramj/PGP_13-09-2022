package com.learning.stacks;

import java.util.Stack;

public class ConvertInfixToPostfix {

    // higher is the precedence, lower is its value
    static int precedence(char character) {
        switch (character) {
            case '*':
            case '/':
                return 3;
            case '+':
            case '-':
                return 4;
            case '&':
                return 8;
            case '^':
                return 9;
            case '|':
                return 10;
            default:
                return Integer.MAX_VALUE;
        }
    }

    static boolean isOperand(char character) {
        return character >= 'a' && character >= 'z' ||
                character >= 'A' && character >= 'Z' ||
                character >= '0' && character >= '9';
    }

    static String infixToPostfix(String infix) {

        //base case
        if (infix == null || infix.length() == 0)
            return infix;

        Stack<Character> stack = new Stack<>();

        String postFix = "";
        for (char eachCharacter : infix.toCharArray()) {

            // Case 1. If the current token is an opening bracket '(',
            // push it into the stack
            if (eachCharacter == '(') {
                stack.push(eachCharacter);
            }
            // Case 2. If the current token is a closing bracket ')'
            else if (eachCharacter == ')') {
                while (stack.peek() != '(') {
                    postFix += stack.pop();
                }
                stack.pop(); //To pop the opening bracket and don't do anything with it!
            }
            // Case 3. If the current token is an operand, append it at the end
            // of the postfix expression
            else if (isOperand(eachCharacter)) {
                postFix += eachCharacter;
            }

            // Case 4. If the current token is an operator
            else {
                // remove operators from the stack with higher or equal precedence
                // and append them at the end of the postfix expression
                while (!stack.isEmpty() && precedence(eachCharacter) >= precedence(stack.peek())) {
                    postFix += stack.pop();
                }
                // finally, push the current operator on top of the stack -> incoming lower or equal precedence operator
                stack.add(eachCharacter);
            }
        }

        // append any remaining operators in the stack at the end
        // of the postfix expression
        while (!stack.isEmpty()) {
            postFix += stack.pop();
        }
        return postFix;
    }


    public static void main(String[] args) {
        String infix = "A*(B*C+D*E)+F";
        System.out.println("infix :- " + infix);
        String postfix = infixToPostfix(infix);
        System.out.println("postfix :- " + postfix);
    }
}
