package Heap;
import java.util.*;

import sorting.sorting;
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
        public void insert(int data){
            h.add(data);
            int x= h.size() -1;
            int par = ( h.size() - 2 ) / 2;
            while(h.get(x) < h.get(par)){
                int temp = h.get(x);
                h.set(x, h.get(par));
                h.set(par, temp);
            }
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
        System.out.println(h.h);
    }
}
