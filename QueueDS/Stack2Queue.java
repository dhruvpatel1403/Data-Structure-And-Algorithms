// package QueueDS;
// import java.util.*;

// public class Stack2Queue {
//     public static class Queue{
//         static Stack<Integer> first = new Stack<>();
//         static Stack<Integer> second = new Stack<>();
//         public static boolean isEmpty(){
//             return first.isEmpty();
//         }
//         public static void add(int data){
//             // while(!first.isEmpty()){
//             //     second.push(first.pop());
//             // }
//             // first.push(data);
//             // while(!second.isEmpty()){
//             //     first.push(second.pop());
//             // }
//             first.push(data);
//         }
//         public static int remove(){
//             if(first.isEmpty()){
//                 System.out.println("Queue is already empty");
//                 return -1;
//             }
//             while(!first.isEmpty()){
//                 second.push(first.pop());
//             }
//             int val = second.pop();
//             while(!second.isEmpty()){
//                 first.push(second.pop());
//             }
//             return val;
//             // return first.pop();
//         }
//         public static int peek(){
//             if(isEmpty()){
//                 System.out.println("Queue is already empty");
//                 return -1;
//             }
//             while (!first.isEmpty()) {
//                 second.push(first.pop());
//             }
//             int val = second.peek();
//             while(!second.isEmpty()){
//                 first.push(second.pop());
//             }
//             return val;
//         }
//     }
//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         while(!q.isEmpty()){
//             System.out.println(q.peek());
//             q.remove();
//         }   
//     }
// }
package QueueDS;
import java.util.*;

public class Stack2Queue {
    public static class OptimizedQueue {
        static Stack<Integer> inputStack = new Stack<>();
        static Stack<Integer> outputStack = new Stack<>();
        
        public static boolean isEmpty() {
            return inputStack.isEmpty() && outputStack.isEmpty();
        }
        
        // O(1) time
        public static void add(int data) {
            inputStack.push(data);
        }
        
        // Amortized O(1) time
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is already empty");
                return -1;
            }
            
            // Only transfer if output stack is empty
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            
            return outputStack.pop();
        }
        
        // Amortized O(1) time
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is already empty");
                return -1;
            }
            
            // Only transfer if output stack is empty
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            
            return outputStack.peek();
        }
    }
    
    public static void main(String[] args) {
        OptimizedQueue q = new OptimizedQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(3);
        q.remove();
        q.remove();
        q.remove();
        q.add(2);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }   
    }
}