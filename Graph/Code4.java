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
    public static void BFS(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                vis[curr] = true;
                System.out.print(curr+" ");
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dst);
                }
            }
        }
    }
    public static void DFS(ArrayList<Edge>[] graph,int curr,boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dst]){
                DFS(graph,graph[curr].get(i).dst, vis);
            }
        }
    }
    public static boolean cycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detect_cycle(graph,i,-1,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detect_cycle(ArrayList<Edge>[] graph,int curr,int par,boolean vis[]){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                if(detect_cycle(graph, e.dst, curr, vis)){
                    return true;
                }
            }else if(e.dst != par){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
       graph[0].add(new Edge(0, 1, 2));
graph[1].add(new Edge(1, 0, 2));

graph[0].add(new Edge(0, 2, 4));
graph[2].add(new Edge(2, 0, 4));

graph[1].add(new Edge(1, 2, 1));
graph[2].add(new Edge(2, 1, 1));

graph[1].add(new Edge(1, 3, 7));
graph[3].add(new Edge(3, 1, 7));

graph[2].add(new Edge(2, 4, 3));
graph[4].add(new Edge(4, 2, 3));

graph[3].add(new Edge(3, 4, 1));
graph[4].add(new Edge(4, 3, 1));

        // for(int i=0;i<V;i++){
        //     for(int j=0;j<graph[i].size();j++){
        //         Edge e = graph[i].get(j);
        //         System.out.println(e.src+" -- "+ e.dst);
        //     }
        // }
        BFS(graph);
        System.out.println();
        DFS(graph, 0, new boolean[V]);
        System.out.println(cycle(graph));
    }
}
