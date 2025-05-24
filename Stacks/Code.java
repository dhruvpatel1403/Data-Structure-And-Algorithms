package Stacks;
import java.util.*;

public class Code {
    // static class Stack{
    //     // static ArrayList<Integer> list = new ArrayList<>();
    //     // public static boolean isEmpty(){
    //     //     if(list.size()>0){
    //     //         return false;
    //     //     }
    //     //     return true;
    //     // }
    //     // public static void push(int data){
    //     //     list.add(data);
    //     // }
    //     // public static int pop(){
    //     //     if(isEmpty()){
    //     //         return Integer.MIN_VALUE;
    //     //     }
    //     //     int val = list.get(list.size()-1);
    //     //     list.remove(list.size()-1);
    //     //     return val;
    //     // }
    //     // public static void peek(){
    //     //     if(isEmpty()){
    //     //         return;
    //     //     }
    //     //     System.out.println(list.get(list.size()-1));
    //     // }
    // //     public class Node{
    // //         int data;
    // //         Node next;
    // //         public Node(int data){
    // //             this.data=data;
    // //             this.next = null;
    // //         }
    // //     }
    // //     public static Node head=null;
    // //     public static Node tail=null;
    // //     public boolean isEmpty(){
    // //         return head==null;
    // //     }
    // //     public void push(int data){
    // //         Node newNode = new Node(data);
    // //         if(head==null){
    // //             head=tail=newNode;
    // //             return;
    // //         }
    // //         newNode.next = head;
    // //         head = newNode;
    // //     }
    // //     public int pop(){
    // //         if(head==null){
    // //             return Integer.MIN_VALUE;
    // //         }
    // //         int val = head.data;
    // //         head = head.next;
    // //         return val;
    // //     }
    // //     public void peek(){
    // //         if(isEmpty()){
    // //             return;
    // //         }
    // //         System.out.println(head.data);
    // //     }
    // }
    public static void pushAtBottom(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int val = s.pop();
        pushAtBottom(data, s);
        s.push(val);
    }
    public static void reverse(String str){
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        int i=0;
        while(i<str.length()){
            s.push(str.charAt(i));
            i++;
        }
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
    public static void nextGreaterElement(int arr[]){
        Stack<Integer> s = new Stack<>();
        int result[] = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(result[i]+" ");
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
        // Stack<Integer> s = new Stack<>();
        // s.push(4);
        // s.push(3);
        // s.push(2);
        // pushAtBottom(1, s);
        // while(!s.isEmpty()){
        //     System.out.println(s.peek());
        //     s.pop();
        // }
        // reverse("iamfine");
        int arr[] = {6,8,0,1,3};
        nextGreaterElement(arr);
    }
}
