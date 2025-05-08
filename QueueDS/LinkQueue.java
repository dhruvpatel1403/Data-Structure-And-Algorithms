package QueueDS;
import java.util.*;

public class LinkQueue {
    static class Queue{
        LinkedList<Integer> q;
        public Queue(){
            q = new LinkedList<>();
        }
        public boolean isEmpty(){
            return q.isEmpty();
        }
        public void add(int data){
            q.addLast(data);
        }
        public int remove(){
            if(q.isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            return q.removeFirst();
        }
        public void peek(){
            System.out.println(q.getFirst());
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
