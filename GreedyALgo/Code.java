package GreedyALgo;
import java.util.*;

public class Code {
    public static void Activity(int start[],int end[]){
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1;i<start.length;i++){
            if(start[i]>=lastEnd){
                maxAct++;
                lastEnd = end[i];
                ans.add(i);
            }
        }
        System.out.println(ans);
        System.out.println(maxAct);
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        Activity(start, end);
    }
}
