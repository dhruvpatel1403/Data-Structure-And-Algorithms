package QueueDS;
import java.util.*;
public class Code2Rep {
    public static void NonRep(String str){
        int arr[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            arr[curr-'a']++;
            q.add(curr);
            while(!q.isEmpty() && arr[q.peek()-'a'] != 1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1 ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
    }

    public static void main(String args[]){
        NonRep("aabccxb");
    }
}
