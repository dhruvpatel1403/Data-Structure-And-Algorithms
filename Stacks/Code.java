package Stacks;
import java.util.*;

public class Code {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            if(list.size()>0){
                return false;
            }
            return true;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            int val = list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }
        public static void peek(){
            if(isEmpty()){
                return;
            }
            System.out.println(list.get(list.size()-1));
        }
    }
    public static void main(String args[]){
        // Stack s = new Stack();
        // s.push(5);
        // s.push(4);
        // s.push(3);
        // while(!s.isEmpty()){
        //     s.peek();
        //     s.pop();
        // }
        Stack s = new Stack();
        s.push(4);
        s.push(3);
        s.push(2);
        while(!s.isEmpty()){
            s.peek();
            s.pop();
        }
    }
}
