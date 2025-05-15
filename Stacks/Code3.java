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
    
    public static void main(String[] args) {
        // reverse("iamfine");
        int arr[] = {4,5,1,7,0,2,3};
        // findNextGreater(arr);
        findnextLesser(arr);
    }
}
