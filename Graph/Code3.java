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
    public static boolean detect_cycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detect_cycle_util(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detect_cycle_util(ArrayList<Edge>[] graph,boolean vis[],int curr,int par){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            if(vis[graph[curr].get(i).dst] && graph[curr].get(i).dst != par){
                return true;
            }
            if(!vis[graph[curr].get(i).dst]){
                if(detect_cycle_util(graph, vis, graph[curr].get(i).dst, curr)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detect_cycle_DFS(ArrayList<Edge>[] graph){
      boolean vis[] = new boolean[graph.length];
      boolean stack[] = new boolean[graph.length];
      for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            if(detect_cycle_dfs_util(graph,i,vis,stack)){
                return true;
            }
        }
      }
      return false;
    }
    public static boolean detect_cycle_dfs_util(ArrayList<Edge>[] graph,int curr,boolean vis[],boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            if(stack[graph[curr].get(i).dst]){
                return true;
            }
            if(!vis[graph[curr].get(i).dst]){
                if(detect_cycle_dfs_util(graph, graph[curr].get(i).dst, vis, stack)){
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }
    public static void topSort(ArrayList<Edge>[] graph){
        Stack<Integer> s= new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                top_sort_util(graph,i,vis,s);
            }
        }   
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        } 
    }
    public static void top_sort_util(ArrayList<Edge>[] graph,int curr,boolean vis[],Stack<Integer> s){
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dst]){
                top_sort_util(graph, graph[curr].get(i).dst, vis, s);
            }
        }
        s.push(curr);
    }
    public static void all_path(ArrayList<Edge>[] graph,int src,int dst,String path,boolean vis[]){
        if(src == dst){
            System.out.println(path+src);
            return;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            all_path(graph, graph[src].get(i).dst, dst, path+src+" ",vis);
        }
        vis[src] = false; // backtrack
    }
    public static void topsort_kahns(ArrayList<Edge>[] graph){
        int indegree[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                indegree[graph[i].get(j).dst]++;
            }
        }
        for(int i=0;i<indegree.length;i++){
           if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                indegree[graph[curr].get(i).dst]--;
                if(indegree[graph[curr].get(i).dst] == 0){
                    q.add(graph[curr].get(i).dst);
                }
            }
        }   
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }
         // 0 
        // graph[0].add(new Edge(0,1,5));

        // // 1
        // graph[1].add(new Edge(1,0,5));
        // graph[1].add(new Edge(1,2,1));
        // graph[1].add(new Edge(1,3,3));


        // // 2
        // graph[2].add(new Edge(2,1,1));
        // graph[2].add(new Edge(2,3,1));
        // graph[2].add(new Edge(2,4,2));


        // // 3
        // graph[3].add(new Edge(3,2,1));
        // graph[3].add(new Edge(3,1,3));


        // // 4
        // graph[4].add(new Edge(2,4,2));
        graph[5].add(new Edge(5, 0, 1));
graph[5].add(new Edge(5, 2, 1));
graph[4].add(new Edge(4, 0, 1));
graph[4].add(new Edge(4, 1, 1));
graph[2].add(new Edge(2, 3, 1));
graph[3].add(new Edge(3, 1, 1));

        // for(int i=0;i<graph[1].size();i++){
        //     System.out.print(graph[1].get(i).dst+" ");
        // }
        // BFS(graph);
        // System.out.println();
        // DFS(graph, new boolean[v], 0);
        // System.out.println(hashPath(graph, new boolean[v], 0, 4));
        // detect_cycle(graph);
        // detect_cycle_DFS(graph);
        // System.out.println(detect_cycle(graph));
        // topSort(graph);
        all_path(graph, 5, 1, "", new boolean[v]);
        topsort_kahns(graph);
    }
}
