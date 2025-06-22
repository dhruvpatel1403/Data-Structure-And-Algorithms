package Graph;
import java.util.*;
public class Code3 {
    public static class Edge{
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
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
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
        for(int i=0;i<graph[1].size();i++){
            System.out.print(graph[1].get(i).dst+" ");
        }

    }
}
