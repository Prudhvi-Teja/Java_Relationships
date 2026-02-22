package JAVA_DSA_Heaps.Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Kth_Frequency {
    public int[] topKFrequent(int[] nums, int k) {

        // First I need to store count of the elements in the Map 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        // Create the min Heap as based on the values so we can maintain the top k frequent elements while poping the min elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> rec : map.entrySet()){
            minHeap.offer(rec);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        // Create a result array to return it
        int[] result = new int[k];
        for(int i =0; i < k; i++){
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}