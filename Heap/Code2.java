package Heap;
import java.util.*;
public class Code2 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4);
        pq.add(1);
        pq.add(3);
        pq.add(7);
        // System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
