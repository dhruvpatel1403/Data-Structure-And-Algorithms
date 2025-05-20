package GreedyALgo;
import java.util.*;

public class Code2 { 
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9}; 
        ArrayList<Integer> list = new ArrayList<>();
        int max = 1;
        int activities[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        int last = activities[0][2];
        list.add(activities[0][0]);
        for(int i=1;i<start.length;i++)
        {
            if(activities[i][1]>last){
                list.add(activities[i][0]);
                last = activities[i][2];
                max++;
            }
        }
        System.out.println("Max activity selected is : "+max);
    }
}
