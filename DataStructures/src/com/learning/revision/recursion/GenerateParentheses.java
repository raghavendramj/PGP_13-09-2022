package com.learning.revision.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        new GenerateParentheses().generateParentheses(3);
    }

    List<String> generateParentheses(int number) {

        List<String> output = new ArrayList<>();
        int open = number;
        int close = number;
        String op = "";
        solve(open, close, op, output);
        System.out.println("Generated combos are :- " + output);
        return null;
    }

    private void solve(int open, int close, String outputStr, List<String> generatedList) {
        if (open == 0 && close == 0) {
            generatedList.add(outputStr);
            return;
        }

        if (open != 0) {
            String op1 = outputStr;
            op1 += "(";
            solve(open - 1, close, op1, generatedList);
        }
        if (close > open) {
            String op2 = outputStr;
            op2 += ")";
            solve(open, close - 1, op2, generatedList);
        }
    }
}
