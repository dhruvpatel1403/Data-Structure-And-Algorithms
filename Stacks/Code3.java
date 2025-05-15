package Stacks;
import java.util.*;

public class Code3 {
    public static void reverse(String str){
        StringBuilder ans = new StringBuilder("");
        Stack<Character> s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            s.push(curr);
        }
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        System.out.println(ans);
    }
    public static void findNextGreater(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nextGr[] = new int[arr.length];
        for(int i = arr.length-1;i>=0;i--){
            //while
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            //if else
            if(s.isEmpty()){
                nextGr[i] = -1;
            }else{
                nextGr[i] = arr[s.peek()];
            }
            // push s
            s.push(i);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(nextGr[i]+" ");
        }
        System.out.println();
    }
    public static void findnextLesser(int arr[]){
        Stack<Integer> s= new Stack<>();
        int n=arr.length;
        int nextls[] = new int[n];
        for(int i=n-1;i>=0;i--){
            //while
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }

            //if else
            if(s.isEmpty()){
                nextls[i] = -1;
            }else{
                nextls[i] = arr[s.peek()];
            }
            // push i
            s.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(nextls[i]+" ");
        }
        System.out.println();
    }
    public static void findPrevGreater(int arr[]){
        Stack<Integer> s= new Stack<>();
        int n= arr.length;
        int prevGr[] = new int[n];
        for(int i=0;i<n;i++){
            //while
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            //if else
            if(s.isEmpty()){
                prevGr[i] = -1;
            }else{
                prevGr[i] = arr[s.peek()];
            }
            // push in stack
            s.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(prevGr[i]+" ");
        }
        System.out.println();
    }
    public static void findPrevLesser(int arr[]){
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int prevLs[] = new int[n];
        for(int i=0;i<n;i++){
            //while
            while(!s.empty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            //if else
            if(s.isEmpty()){
                prevLs[i] = -1;
            }else{
                prevLs[i] = arr[s.peek()];
            }
            // push in stack
            s.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(prevLs[i]+" ");
        }
        System.out.println();
    }
    public static void stockSpan(int arr[]){
        Stack<Integer> s = new Stack<>();
        int n= arr.length;
        int span[] = new int[n];
        for(int i=0;i<arr.length;i++){
            //while
            while(!s.isEmpty() && arr[s.peek()]<arr[i]){
                s.pop();
            }
            //if else
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                span[i] = i - s.peek();
            }
            // push ele in s
            s.push(i);
        }
        for(int i=0;i<n;i++){
            System.out.print(span[i]+" ");
        }
        System.out.println();
    }
    public static boolean validPara(String str){
        Stack<Character> s =new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                s.push(curr);
            }else{
                if(s.isEmpty()){
                    return false;
                }else{
                    s.pop();
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // reverse("iamfine");
        int arr[] = {100,80,60,70,60,85,100,120};
        // findNextGreater(arr);
        // findnextLesser(arr);
        // findPrevGreater(arr);
        // findPrevLesser(arr);
        // stockSpan(arr);
        System.out.println(validPara("({{}}])"));
    }
}
