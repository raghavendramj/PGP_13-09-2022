package com.learning.strings;

public class PermutationOfAString {


    public static void main(String[] args) {
        PermutationOfAString object = new PermutationOfAString();
        String input = "raghav";
        object.permute(input, 0, input.length() - 1);

    }

    void permute(String inpStr, int start, int end) {

        if (start == end) {
            System.out.println(inpStr);
        } else {
            for (int i = start; i <= end; i++) {
                inpStr = swap(inpStr, start, i);//getting all the string combinations.
                permute(inpStr, start + 1, end);
                inpStr = swap(inpStr, start, i);//getting all the string combinations.
            }
        }

    }

    String swap(String inpStr, int i, int j) {
        char myArr[] = inpStr.toCharArray();
        char temp = myArr[i];
        myArr[i] = myArr[j];
        myArr[j] = temp;

        return String.valueOf(myArr);
    }
}
