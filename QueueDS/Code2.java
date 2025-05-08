package QueueDS;
import java.util.*;

public class Code2 {
    public static void nonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1"+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void interLeave(Queue<Integer> main){
        int sz = main.size();
        Queue<Integer> first = new LinkedList<>();
        int i=0;
        while(i<sz/2){
            first.add(main.remove());
            i++;
        }
        while(!first.isEmpty()){
            main.add(first.remove());
            main.add(main.remove());
        }
        System.out.println(main);
    }
    public static void main(String args[]){
        String str = "aabccxb";
        // nonRepeating(str);
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q);
        interLeave(q);
    }
}
