package Graph;
import java.util.*;
public class Code2 {
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
    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dst);
                }
            }
        }
        System.out.println();
    }
    public static void DFS(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dst]){
                DFS(graph, graph[curr].get(i).dst, vis);
            }
        }
    }
    public static boolean hashPath(ArrayList<Edge>[] graph,int src,int dst,boolean vis[]){
        if(src==dst){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            if(!vis[graph[src].get(i).dst]){
                if(hashPath(graph, graph[src].get(i).dst, dst, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 1));

        // 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 1));

        // Call BFS and DFS
        BFS(graph);
        DFS(graph, 0, new boolean[graph.length]);
        System.out.println();
        System.out.println(hashPath(graph, 0, 4, new boolean[graph.length]));
    }
}
