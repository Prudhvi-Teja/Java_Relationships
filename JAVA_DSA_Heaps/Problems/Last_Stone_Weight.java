package JAVA_DSA_Heaps.Problems;

import java.util.Collections;

// This problem related to find the max elements and substract them utill we find one element in array

// so the problem is to find the max element for every iteration and removing the used greater so in such a case 

// We use with maxHeap, we will get max element from the top of peak

// First we will store all elements in heap, so max element at top 

// every iteration we will poll from maxHeap, so next greater element will be at the top

// As per the code we need to do substraction if both are not same, if both are same we need to remove both

// so here the logic

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // By default its min heap if we keep reverse it is maxheap;

        // so insert elements in a max Heap 

        for(int stone : stones){
            maxHeap.offer(stone);
        }
        
        // Do operation untill size 1;
        while(maxHeap.size() > 1){
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(x != y)
                maxHeap.offer(y-x);
        }

        // if heap size > 0 return peek element or 0
        return maxHeap.size() > 0 ? maxHeap.poll() : 0;

    }
}