package JAVA_DSA_Heaps.Problems;

//Points to remember Kth largest element is kth smallest element from the larger numbers

// so Our approach is adding elements to min heap by Maintaing size k 

// Before adding the element we are checking the condition element should be greater than the minHeap top element 

// while adding the elements to min heap if heap size greater that k remove the top element and continue maintaing size of k

import java.util.PriorityQueue;

class Kth_Largest_Element {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
// Before adding the element we are checking the condition element should be greater than the minHeap top element before you need to elements untill size K
        for(int num : nums){
            if(queue.size() < k){
                queue.offer(num);
            }
            else if(num >= queue.peek()){
                queue.offer(num);
                queue.poll();
            }
        }
        return queue.peek();
    }
}
