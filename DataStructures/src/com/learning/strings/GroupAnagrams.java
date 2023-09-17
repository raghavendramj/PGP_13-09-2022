package com.learning.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String groups[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(groups);
    }

    static double primeProduct(String s) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double result = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result = result * primes[c - 'a']; //Range -> 26 -> 10 => 29*1 => 29

            //a-> 2, b-> 3, c -> 5
        }
        return result;
    }

    static List<List<String>> groupAnagrams(String[] strs) {


        HashMap<String, List<String>> groupMaps = new HashMap<>();
        for (String eachStr : strs) {
            char eachArr[] = eachStr.toCharArray(); //eat, tea, ate
            Arrays.sort(eachArr);
            String sortedStr = String.valueOf(eachArr);
            List<String> eachGroup = new ArrayList<>();
            if (groupMaps.containsKey(sortedStr)) { //aet, aet, aet
                eachGroup = groupMaps.get(sortedStr);
            }
            eachGroup.add(eachStr); //List of actual anagram strings
            groupMaps.put(sortedStr, eachGroup);
        }
        System.out.println("groupMaps -> "+groupMaps);
        return new ArrayList<>(groupMaps.values());
    }
}
