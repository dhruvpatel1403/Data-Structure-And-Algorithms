package Heap;
import java.util.*;

public class Code {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name,int rank){
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    static class Heap{
        ArrayList<Integer> h = new ArrayList<>();
        public void insert(int data) {
        h.add(data);
        int x = h.size() - 1;  // Current index of the new element
        while (x > 0) {
            int par = (x - 1) / 2;  // Parent index
            if (h.get(x) < h.get(par)) {  // Min-heap condition
                // Swap child and parent
                int temp = h.get(x);
                h.set(x, h.get(par));
                h.set(par, temp);
                x = par;  // Move up to the parent's position
            } else {
                break;  // Stop if the heap property is satisfied
            }
        }
        }
        public int remove(){

            // step 1 : swap first with last value in heap
            int data = h.get(0);
            h.set(0,h.get(h.size()-1));
            h.set(h.size()-1,data);

            // Step 2 : delete last Node 
            h.remove(h.size()-1);

            // Step 3 : Heapify
            heapify(0);
            
            return data;
        }
        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minInd = i;

            if(left < h.size() && h.get(minInd)>h.get(left)){
                minInd = left;
            }

            if(right < h.size() && h.get(minInd) > h.get(right)){
                minInd = right;
            }
            if(minInd != i){
                int temp = h.get(i);
                h.set(i,h.get(minInd));
                h.set(minInd, temp);

                heapify(minInd);
            }
        }
        public void peek(){
            System.out.println(h.get(0));
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Dhruv",1));
        pq.add(new Student("Dhruvansh",5));
        pq.add(new Student("Alay",10));
        pq.add(new Student("Jay",2));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name);
            pq.remove();
        }
        Heap h = new Heap();
        h.insert(3);
        h.insert(4);
        h.insert(2);
        h.insert(1);
        h.remove();
        System.out.println(h.h);
        h.peek();
    }
}
