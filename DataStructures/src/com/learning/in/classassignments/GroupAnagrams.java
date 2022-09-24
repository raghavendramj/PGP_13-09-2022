package com.learning.in.classassignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("1. Grouped anagrams are .. " + groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        //Base Case
        if (strs.length <= 1)
            return Arrays.asList();

        if (strs.length == 1) {
            List eachGroup = new ArrayList();
            eachGroup.add(strs[0]);
            return groups;
        }

        HashMap<String, List<String>> groupMap = new HashMap<>();
        for (String eachString : strs) {
            char eachCharArray[] = eachString.toCharArray();
            Arrays.sort(eachCharArray);

            String sortedStr = String.valueOf(eachCharArray);
            List eachGroup = new ArrayList();
            if (groupMap.containsKey(sortedStr)) {
                eachGroup = groupMap.get(sortedStr);
            }
            eachGroup.add(eachString);
            groupMap.put(sortedStr, eachGroup);
        }
        return new ArrayList<>(groupMap.values());
    }

}
