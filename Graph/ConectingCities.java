package Graph;

import java.util.PriorityQueue;

public class ConectingCities{
    static class Edge implements Comparable<Edge>{
        int dst;
        int wt;
        public Edge(int d,int w){
            this.dst = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    public static int conCities(int cities[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
        boolean vis[] = new boolean[cities.length];
        int finalCost = 0;
        while(!pq.isEmpty()){
            Edge e = pq.remove();
            if(!vis[e.dst]){
                vis[e.dst] = true;
                finalCost+= e.wt;
                for(int i=0;i<cities[e.dst].length;i++){
                    if(cities[e.dst][i] != 0){
                        pq.add(new Edge(i,cities[e.dst][i]));
                    }
                }
            }

        }
        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][] = { {0,1,2,3,4},
                            {1,0,5,0,7},
                            {2,5,0,6,0},
                            {3,0,6,0,0},
                            {4,7,0,0,0} };
        System.out.println(conCities(cities));
    }
}
