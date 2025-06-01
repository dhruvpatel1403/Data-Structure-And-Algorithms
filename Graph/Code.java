package Graph;
import java.util.*;
public class Code {
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dst = d;
            this.wt = w;
        }
    }
    // public static void BFS(ArrayList<Edge>[] graph){
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean visited[] = new boolean[graph.length];
    //     q.add(graph[0].get(0).src);
    //     while(!q.isEmpty()){
    //         int curr = q.remove();
    //         if(!visited[curr]){
    //             visited[curr] = true;
    //             System.out.print(curr + " ");
    //             for(int i=0;i<graph[curr].size();i++){
    //                 q.add(graph[curr].get(i).dst);
    //             }
    //         }
    //     } 
    // }
    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean isVisited[] = new boolean[graph.length];
        q.add(0);
        
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!isVisited[curr]){
                isVisited[curr] = true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dst);
                }
            }
            
        }
    }
    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v]; // null convert it to new ArrayList

        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        // 0 
        graph[0].add(new Edge(0,1,5));

        // 1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));


        // 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));


        // 3

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));


        // 4
        graph[4].add(new Edge(2,4,2));

        // print ngb of 2
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dst);
        }

        BFS(graph);

    }
}
