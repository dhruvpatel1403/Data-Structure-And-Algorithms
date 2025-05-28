package Hashmap;
import java.util.*;
public class Code {
    public static void sumZero(int arr[]){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
            if(hm.containsKey(sum)){
                len = Math.max(len,i - hm.get(sum));
            }
            else{
                hm.put(sum, i);
            }
        }
        System.out.println(len);
    }
    public static void sumK(int arr[],int k){
        int sum = 0;
        int ans = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        int arr[] = { 10,2,-2,-20,10};
        sumZero(arr);
        sumK(arr, -10);
    }
}
