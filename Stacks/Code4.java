package Stacks;
import java.util.*;
public class Code4 {
    public static void nextGreater(int arr[]){
        int ans[] = new int[arr.length];
        Stack<Integer> s= new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
   
    public static void main(String[] args) {
        int arr[] = {100,80,60,70,60,85,100};
        stockSpan(arr);
    }
}
