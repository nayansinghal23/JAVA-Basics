// https://leetcode.com/problems/find-median-from-data-stream/
package IntroTopics.Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2
    }
}


class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half
    private PriorityQueue<Integer> minHeap; // Stores the larger half

    public MedianFinder() {
        // maxHeap uses Collections.reverseOrder() to keep the largest element at the top
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // minHeap keeps the smallest element at the top by default
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to maxHeap first
        maxHeap.offer(num);
        
        // Step 2: Balancing step - ensure every element in maxHeap is <= every element in minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Maintain size property - maxHeap can have at most 1 more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // If total elements are odd, maxHeap will have the extra middle element
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // If total elements are even, return the average of the tops of both heaps
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}