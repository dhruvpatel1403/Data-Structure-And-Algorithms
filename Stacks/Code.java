package Stacks;
import java.util.*;

public class Code {
    static class Stack{
        // static ArrayList<Integer> list = new ArrayList<>();
        // public static boolean isEmpty(){
        //     if(list.size()>0){
        //         return false;
        //     }
        //     return true;
        // }
        // public static void push(int data){
        //     list.add(data);
        // }
        // public static int pop(){
        //     if(isEmpty()){
        //         return Integer.MIN_VALUE;
        //     }
        //     int val = list.get(list.size()-1);
        //     list.remove(list.size()-1);
        //     return val;
        // }
        // public static void peek(){
        //     if(isEmpty()){
        //         return;
        //     }
        //     System.out.println(list.get(list.size()-1));
        // }
        public class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next = null;
            }
        }
        public static Node head=null;
        public static Node tail=null;
        public boolean isEmpty(){
            return head==null;
        }
        public void push(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public int pop(){
            if(head==null){
                return Integer.MIN_VALUE;
            }
            int val = head.data;
            head = head.next;
            return val;
        }
        public void peek(){
            if(isEmpty()){
                return;
            }
            System.out.println(head.data);
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
