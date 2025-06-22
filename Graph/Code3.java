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
    public static void BFS(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dst);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge>[] graph,boolean vis[],int curr){

        vis[curr]= true;

        System.out.print(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dst]){
                DFS(graph, vis, graph[curr].get(i).dst );
            }
        }
    }
    public static boolean hashPath(ArrayList<Edge>[] graph,boolean vis[],int src,int dst){
        if(src == dst){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            if(!vis[graph[src].get(i).dst] && hashPath(graph, vis, graph[src].get(i).dst, dst)){
                return true;
            }
        }
        return false;
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
        // for(int i=0;i<graph[1].size();i++){
        //     System.out.print(graph[1].get(i).dst+" ");
        // }
        BFS(graph);
        System.out.println();
        DFS(graph, new boolean[v], 0);
        System.out.println(hashPath(graph, new boolean[v], 0, 4));
    }
}
