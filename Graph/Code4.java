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
    public static boolean detect_cycle_directed(ArrayList<Edge>[] graph) {
    boolean[] vis = new boolean[graph.length];
    boolean[] stack = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
        if (!vis[i]) {
            if (detect_cycle_directed_util(graph, i, vis, stack)) {
                return true;
            }
        }
    }
    return false;
}

public static boolean detect_cycle_directed_util(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
    vis[curr] = true;
    stack[curr] = true;

    for (Edge e : graph[curr]) {
        if (stack[e.dst]) {
            return true; // back edge found
        }

        if (!vis[e.dst]) {
            if (detect_cycle_directed_util(graph, e.dst, vis, stack)) {
                return true;
            }
        }
    }

    stack[curr] = false; // backtrack
    return false;
}
    public static void topo_sort(ArrayList<Edge>[] graph){
        Stack<Integer> s= new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topo_sort_util(graph,i,s,vis);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");;
        }
    }
    public static void topo_sort_util(ArrayList<Edge>[] graph,int curr,Stack<Integer> s,boolean vis[]){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                topo_sort_util(graph, e.dst, s, vis);
            }
        }
        s.push(curr);
    }
    public static void indegree(ArrayList<Edge>[] graph,int ind[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                ind[e.dst]++;
            }
        }
    }
    public static void top_sort_kahns(ArrayList<Edge>[] graph){
        int ind[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        indegree(graph,ind);
        for(int i=0;i<ind.length;i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e= graph[curr].get(i);
                ind[e.dst]--;
                if(ind[e.dst] == 0){
                    q.add(e.dst);
                }
            }
        }

    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
       graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 2, 1));
// No edge back to 0


        // for(int i=0;i<V;i++){
        //     for(int j=0;j<graph[i].size();j++){
        //         Edge e = graph[i].get(j);
        //         System.out.println(e.src+" -- "+ e.dst);
        //     }
        // }
        // BFS(graph);
        // System.out.println();
        // DFS(graph, 0, new boolean[V]);
        // System.out.println(cycle(graph));
        System.out.println(detect_cycle_directed(graph));
        topo_sort(graph);
        System.out.println();
        top_sort_kahns(graph);
    }
}
