import java.util.*;
public class Rec2 {
    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }
        return tilling(n-1) + tilling(n-2);
    }
    public static void removeDuplicates(String str,StringBuilder sb,int i,ArrayList<Boolean> arr){
        if(i==str.length()){
            System.out.println(sb);
            return;
        }
        if(!arr.get(str.charAt(i)-'a')){
            arr.add(str.charAt(i)-'a',true);
            sb.append(str.charAt(i));
        }
        removeDuplicates(str, sb, i+1, arr);
    }
    public static int friendsPair(int n){
        if(n==0 || n==1){
            return n;
        }
        return friendsPair(n-1) + (n-1)*friendsPair(n-1);
    }
    public static void printBinaryString(int n,String str,int last){
        if(n==str.length()){
            System.out.println(str);
            return;
        }
        printBinaryString(n, str + "0", 0);
        if(last==0){
            printBinaryString(n, str+"1", 1);
        }
    }
    public static void main(String[] args) {
        // System.out.println(tilling(3));
        // boolean arr[] = new boolean[26];
        ArrayList<Boolean> list = new ArrayList<>(Collections.nCopies(26,false));
        // removeDuplicates("heeelloiamfine", new StringBuilder(""), 0, list);
        // System.out.println(friendsPair(3));
        printBinaryString(3, "", 0);
    }
}
