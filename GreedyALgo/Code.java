package GreedyALgo;
import java.util.*;

public class Code {
    public static void Activity(int start[],int end[]){
        int activity[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        Arrays.sort(activity,Comparator.comparingDouble(o -> o[2]));
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(activity[0][0]);
        int lastEnd = activity[0][0];
        for(int i=1;i<start.length;i++){
            if(activity[i][1]>=lastEnd){
                maxAct++;
                lastEnd = activity[i][2];
                ans.add(activity[i][0]);
            }
        }
        System.out.println(ans);
        System.out.println(maxAct);
    }
    public static void fract(int weight[],int value[],int capacity){
        int maxValue = 0;
        double ratio[] = new double[value.length];
        for(int i=0;i<value.length;i++){
            ratio[i] = value[i] / (double)weight[i];
        }
        double rationSort[][] = new double[ratio.length][2];
        for(int i=0;i<ratio.length;i++){
            rationSort[i][0] = i;
            rationSort[i][1] = (double)ratio[i];
        }
        Arrays.sort(rationSort,Comparator.comparingDouble(o -> o[1]));
        for(int i=rationSort.length-1;i>=0;i--){
            if(capacity>=weight[(int)rationSort[i][0]]){
                maxValue += value[(int)rationSort[i][0]];
                capacity = capacity - weight[(int)rationSort[i][0]];
            }else{
                maxValue += capacity * (double)ratio[(int)rationSort[i][0]];
                break;
            }
        }
        System.out.println(maxValue);
    }
    public static void minAbsDIff(int arr1[],int arr2[]){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minDif = 0;
        for(int i=0;i<arr1.length;i++){
            minDif += Math.abs(arr1[i]-arr2[i]);
        }
        System.out.println(minDif);
    }
    public static void main(String[] args) {
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};
        // Activity(start, end);
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        // int capacity = 50;
        // fract(weight, value, capacity);
        minAbsDIff(value, weight);
    }
}
