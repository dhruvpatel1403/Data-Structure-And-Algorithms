package QueueDS;
import java.util.*;

public class Stack2Queue {
    public static class Queue{
        static Stack<Integer> first = new Stack<>();
        static Stack<Integer> second = new Stack<>();
        public static boolean isEmpty(){
            return first.isEmpty();
        }
        public static void add(int data){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            first.push(data);
            while(!second.isEmpty()){
                first.push(second.pop());
            }
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            return first.pop();
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            return first.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }   
    }
}
