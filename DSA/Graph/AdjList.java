package DSA.Graph;
import java.util.*;

class InnerAdjList {

    public boolean isUndirected;
    public List<List<Integer>> list;

    public InnerAdjList(int size, boolean isUndirected){
        this.isUndirected = isUndirected;
        this.list = new ArrayList<>();
        for(int i =0; i < size; i++){
            List<Integer> temp = new ArrayList<>();
            this.list.add(temp);
        }
    }

    public void addVertices(int node, int neighbours){
        this.list.get(node).add(neighbours);
        if(isUndirected)
            this.list.get(neighbours).add(node);
    }
    
    public void printAdjList(){
        for(List<Integer> nodes: list)
            System.out.println(nodes);
    }
}

public class AdjList {
    public static void main(String[] args) {
        InnerAdjList innerAdjList = new InnerAdjList(5, true);
        innerAdjList.addVertices(0, 1);
        innerAdjList.addVertices(0, 3);
        innerAdjList.addVertices(1, 2);
        innerAdjList.addVertices(2, 3);
        innerAdjList.addVertices(3, 4);

        innerAdjList.printAdjList();
    }
}
