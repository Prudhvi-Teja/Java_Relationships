package JAVA_DSA_Heaps;

import java.util.List;
import java.util.ArrayList;

public class Min_Heap {

    private List<Integer> minHeap;

    public Min_Heap(){
        this.minHeap = new ArrayList<>();
    }

    public void insert(int ele){
        System.out.println("Inseting "+ele);
        this.minHeap.add(ele);
        System.out.println("Before swap" + this.minHeap);
        this.minHeapBalance(this.minHeap.size()-1);
        System.out.println("After swap" + this.minHeap);
    }

    private void minHeapBalance(int index){
        int parentIndex = (index - 1)/2;
        while(index > 0 && index < minHeap.size() && minHeap.get(index) < minHeap.get(parentIndex)){
            swapNode(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1)/2;
        }
    }

    private void swapNode(int i, int j){
         System.out.println("swapping index from "+minHeap.get(i)+" to "+minHeap.get(j));
        int temp = this.minHeap.get(j);
        this.minHeap.set(j, this.minHeap.get(i));
        this.minHeap.set(i, temp);
    }
    
}
