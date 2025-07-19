package Graph;
import java.util.*;
public class Code4 {
    static class Edge{
        int src;
        int dst;
        int wt;
        public Edge(int src,int dst,int wt){
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 4, 1));
        // for(int i=0;i<V;i++){
        //     for(int j=0;j<graph[i].size();j++){
        //         Edge e = graph[i].get(j);
        //         System.out.println(e.src+" -- "+ e.dst);
        //     }
        // }
        // BFS(graph);
    }
}
