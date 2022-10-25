package com.learning.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Double> maxHeap;
    PriorityQueue<Double> minHeap;

    public MedianFinder() {
        //maxHeap = new PriorityQueue<>((a, b) -> b - a);
        //minHeap = new PriorityQueue<>((a, b) -> a - b);

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(double num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        //Readjust the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            Double removedLargestElement = maxHeap.poll();
            minHeap.add(removedLargestElement);
        } else if (maxHeap.size() < minHeap.size()) {
            Double removedSmallestElement = minHeap.poll();
            maxHeap.add(removedSmallestElement);
        }
    }

    public double findMedian() {
        //If both the heaps are same size.
        if (maxHeap.size() == minHeap.size()) {
            Double median = (minHeap.peek() + maxHeap.peek()) / 2;
            return median;
        }

        //if max-heap is having one size greater
        return maxHeap.peek();
    }
}
