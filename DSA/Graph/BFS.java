package DSA.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends AdjList{
 
    boolean[] visited;
    public boolean isUndirected;
    public List<List<Integer>> list;

    BFS(int n, boolean undirected){
        this.visited = new boolean[n+1];
        this.isUndirected = false;
        this.list = new ArrayList<>();
        for(int i=0; i < n ;i++){
            List<Integer> temp = new ArrayList<>();
            this.list.add(temp);
        }
    }

    public boolean bfsCore(int vertices){
        if(visited[vertices]==false){
            visited[vertices] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(vertices);
            while(!queue.isEmpty()){
                System.out.println(queue.peek());
                int neighbourin = queue.remove();
                List<Integer> ngList = list.get(neighbourin);
                for(Integer nghList : ngList){
                    if(visited[nghList]==false){
                        visited[nghList] = true;
                        queue.add(nghList);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean bfs(int vertices){
        for(int i =0; i < visited.length; i++){
            if(visited[i]== false)
                bfsCore(vertices);
        }
        return true;
    }
}
