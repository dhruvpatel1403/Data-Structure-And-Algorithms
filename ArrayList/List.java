package ArrayList;
import java.util.*;

public class List {

    public static boolean monotone(ArrayList<Integer> list){
        boolean inc = true;
        boolean dec = true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }
            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
            if(!inc && !dec){
                return false;
            }
        }
        return true;
    }
    public static int CalWater(ArrayList<Integer> list){
        int maxWater = 0;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int height = Math.min(list.get(i),list.get(j));
                int witdth = j-i;
                int water = height*witdth;
                maxWater = Math.max(maxWater,water);
            }
        }
        return maxWater;
    }
    public static int calWaterPointer(ArrayList<Integer> list){
        int lp = 0;
        int rp = list.size() -1;
        int maxWater = 0;
        while(lp < rp){
            int ht = Math.min(list.get(lp),list.get(rp));
            int wd = rp-lp;
            int water = ht*wd;
            maxWater = Math.max(maxWater,water);
            if(list.get(lp)>list.get(rp)){
                rp--;
            }
            else{
                lp++;
            }
        }
        return maxWater;
    }
    public static boolean pairSum(ArrayList<Integer> list,int target){
        int lp = 0;
        int rp = list.size() -1;
        while(lp<rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            else if(list.get(lp) + list.get(rp) > target){
                rp--;
            }
            else{
                lp++;
            }
        }
        return false;
    }
    public static boolean pariSumRotated(ArrayList<Integer> list,int target){
        int pivot = 0;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                pivot=i+1;
            }
        }
        int lp=pivot;
        int rp=pivot-1;
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target){
                lp = (lp+1) % (list.size());
            }
            else{
                rp = (list.size() + rp -1) % (list.size());
            }
        }
        return false;
    }
    public static void lonely(ArrayList<Integer> list){
        Collections.sort(list);
        if(list.size() >= 2){
            for(int i=1;i<list.size()-1;i++){
                if(list.get(i-1) )
            }
        }
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        // list.add(9);
        // list.add(15);
        // // list.add(4);
        // // list.add(8);
        // // list.add(3);
        // list.add(0);
        // System.out.println(CalWater(list));
        // System.out.println(calWaterPointer(list));
        // System.out.println(pairSum(list, 16));
        // System.out.println(pariSumRotated(list, 16));
        // System.out.println(monotone(list));
        System.out.println(monotone(list));
    }
}
