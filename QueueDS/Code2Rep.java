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
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> t = new LinkedList<>();
        int sz = q.size();
        for(int i=0;i<sz/2;i++){
            t.add(q.remove());
        }
        while(!t.isEmpty()){
            q.add(t.remove());
            q.add(q.remove());
        }
        System.out.println(q);
    }

    public static void main(String args[]){
        // NonRep("aabccxb");
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=10;i++){
            q.add(i);
        }
        System.out.println(q.size());
        interLeave(q);
    }
}
