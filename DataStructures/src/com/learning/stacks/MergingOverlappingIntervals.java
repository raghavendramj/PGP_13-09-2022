package com.learning.stacks;

import java.util.*;

// A class to represent an interval
class Interval {
    int begin, end;

    Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + ", " + end + "}";
    }
}

public class MergingOverlappingIntervals {
    // Function to merge overlapping intervals
    public static void mergeIntervals(List<Interval> intervals) {
        // sort the intervals in increasing order of their starting time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.begin));

        // create an empty stack
        Stack<Interval> stack = new Stack<>();

        // do for each interval
        for (Interval curr : intervals) {
            // if the stack is empty or the top interval in the stack does not overlap
            // with the current interval, push it into the stack
            if (stack.empty() || curr.begin > stack.peek().end) {
                stack.push(curr);
                continue;
            }

            // if the top interval of the stack overlaps with the current interval,
            // merge two intervals by updating the end of the top interval
            // to the current interval
            if (stack.peek().end < curr.end) {
                stack.peek().end = curr.end;
            }
        }

        // print all non-overlapping intervals
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5), new Interval(2, 3),
                new Interval(4, 6), new Interval(7, 8),
                new Interval(8, 10), new Interval(12, 15)
        );

        mergeIntervals(intervals);
    }
}
