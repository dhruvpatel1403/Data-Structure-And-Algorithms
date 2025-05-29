package Heap;
import java.util.*;
public class Code2 {
    public static class Student implements Comparable<Student>{
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
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Dhruv",1));
        pq.add(new Student("Dhruvansh",100));
        pq.add(new Student("Alay",100000));
        pq.add(new Student("Jax",2));
        // System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.remove().rank);
        }
    }
}
