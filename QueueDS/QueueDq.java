package QueueDS;
import java.util.*;

public class QueueDq {
    public static class Queue{
        Deque<Integer> d= new LinkedList<>();
        public boolean isEmpty(){
            return d.isEmpty();
        }
        public void add(int data){
            d.addLast(data);
        }
        public int remove(){
            return d.removeFirst();
        }
        public int peek(){
            return d.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
