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
    public static void DFS(ArrayList<Edge>[] graph,boolean isVisited[],int curr){
        System.out.print(curr+" ");
        isVisited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            if(!isVisited[graph[curr].get(i).dst]){
                DFS(graph, isVisited, graph[curr].get(i).dst);
            }
        }
    }
    public static boolean hashPath(ArrayList<Edge>[] graph,boolean isVisited[],int src,int dest){
        if(src == dest){
            return true;
        }
        isVisited[src] = true;
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!isVisited[e.dst] && hashPath(graph, isVisited,e.dst , dest)){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if (isCycleUtil(graph,i,vis,stack)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(stack[e.dst]){
                return true;
            }
            if(!vis[e.dst]){
                if(isCycleUtil(graph, e.dst, vis, stack)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void topSort(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,vis,s,i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph,boolean[] vis,Stack<Integer> s,int curr){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dst]){
                topSortUtil(graph, vis, s, graph[curr].get(i).dst);
            }
        }
        s.push(curr);
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
        System.out.println();
        DFS(graph, new boolean[graph.length], 0);
        System.out.println();
        System.out.println(hashPath(graph, new boolean[v], 1, 5));
        System.out.println();
        System.out.println(isCycle(graph));
        System.out.println();
        topSort(graph);
    }
}
