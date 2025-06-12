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
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                return detectCycleUtil(graph,vis,i,-1);
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(vis[e.dst] && e.dst != par){
                return true;
            }
            if(!vis[e.dst]){
                return detectCycleUtil(graph, vis, e.dst, curr);
            }
        }
        return false;
    }
    public static void topologicalSort(ArrayList<Edge>[] graph){
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topologicalSortUtil(graph,vis,s,i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge>[] graph,boolean vis[],Stack<Integer> s,int curr){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                topologicalSortUtil(graph, vis, s, e.dst);
            }
        }
        s.push(curr);
    }
    public static void calInd(ArrayList<Edge>[] graph,int[] ind){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e= graph[i].get(j);
                ind[e.dst]++;
            }
        }
    }
    public static void topSortBFS(ArrayList<Edge>[] graph){
        int ind[] = new int[graph.length];
        calInd(graph, ind);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<ind.length;i++){
            if(ind[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                ind[e.dst]--;
                if(ind[e.dst]==0){
                    q.add(e.dst);
                }
            }
        }
        System.out.println();

    }
    public static void printAllPath(ArrayList<Edge>[] graph,int src,int dest,String path){
        path+=src;
        if(src == dest){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dst, dest, path);
        }
    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n,int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph,int src){ // o(v + E*log(v))
        int dis[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];

        for(int i=0;i<dis.length;i++){
            if( src != i){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dst;
                    int wt = e.wt;
                    if(dis[u] + wt < dis[v]){
                        dis[v] = dis[u] + wt;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
        
        }

        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+ " ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // // 0
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));

        // // 1
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));

        // // 2
        // graph[2].add(new Edge(2, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));

        // // 3
        // graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 2, 1));
        
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 3, 1));

        // 2
        graph[2].add(new Edge(2, 3, 1));

        // Call BFS and DFS
        // BFS(graph);
        // DFS(graph, 0, new boolean[graph.length]);
        // System.out.println();
        // System.out.println(hashPath(graph, 0, 4, new boolean[graph.length]));
        // System.out.println(detectCycle(graph));
        topologicalSort(graph);
        System.out.println();
        topSortBFS(graph);
        int src = 0;
        int dst = 3;
        printAllPath(graph, src, dst, "");

        System.out.println();
        dijkstra(graph, src);
    }
}
