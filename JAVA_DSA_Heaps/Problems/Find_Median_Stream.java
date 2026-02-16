package JAVA_DSA_Heaps.Problems;

// Points to remember T.C => O(Nlogk) S.C => O(N) 

// Median is the middle element of Array, so if the length is odd median is middle 
// If it is even, media is sum of middle two elements divided by 2

// Coming to solution we need to find median for stream

// Approach we are taking into to 2 parts one is lower half and upper half which is left and right
// [ 2,5,4,3, 4,6]. => [ 2, 5, 4] & [ 3, 4, 6]
// After spliting taking max Heap as left half and min heap is right ( Note the array is not sorted so considering this we are taking heaps)

// Before continuing we have some conditions like while adding elements to heap
// 1. MaxHeap size should be greather than or more than 1 by MinHeap
// 2. MaxHeap max element(top element) should be less than Min heap min element (top element)
// 3. MinHeap size should not be greather than MaxHeap, it is happenns poll from minHeap and add it to max Heap

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap, maxHeap;


    public MedianFinder() {
        this.minHeap = new PriorityQueue<>(); // By defalut it's min Heap
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // if we pass reverse it will become max Heap
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        // 1. MaxHeap size should be greather than or more than 1 by MinHeap if it greather than 1 then
        if(maxHeap.size() - minHeap.size() >= 2)
            minHeap.offer(maxHeap.poll());
        // 2. MaxHeap max element(top element) should be less than Min heap min element (top element), if it greather than then
        if(minHeap.size() > 0 && maxHeap.peek() > minHeap.peek())
            minHeap.offer(maxHeap.poll());
        //3. MinHeap size should not be greather than MaxHeap, it is happenns poll from minHeap and add it to max Heap
        if(minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) // If it is even, media is sum of middle two elements divided by 2.0
            return (maxHeap.peek() + minHeap.peek())/2.0;
        else // Median is the middle element of Array, so if the length is odd median is middle
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */