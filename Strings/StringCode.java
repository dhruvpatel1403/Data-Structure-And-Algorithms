package Strings;
import java.util.*;

public class StringCode {
    public static void isPalindrome(String str){
        int lp = 0;
        int rp = str.length()-1;
        while(lp<rp){
            if(str.charAt(lp) != str.charAt(rp)){
                System.out.println("String is not palindrome");
                return;
            }
            lp++;
            rp--;
        }
        System.out.println("String is palindrome");
    }
    public static void shortestPath(String str){
        int x=0;
        int y=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='N'){
                y++;
            }
            else if(str.charAt(i)=='S'){
                y--;
            }
            else if(str.charAt(i)=='E'){
                x--;
            }
            else{
                x++;
            }
        }
        int x2 = x*x;
        int y2=y*y;
        double ans = Math.sqrt(x2+y2);
        System.out.println(ans);
    }
    public static void findMax(String arr[]){
        String max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(max.compareTo(arr[i])<0){
                max= arr[i];
            }
        }
        System.out.println("max is : "+max);
    }
    public static void converter(String str,StringBuilder ans){
        ans.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' '){
                ans.append(str.charAt(i));
                i++;
                ans.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                ans.append(str.charAt(i));
            }

        }
        System.out.println("answer is : "+ans);
    }
    public static void stringCompre(String str,StringBuilder ans){
        int i=0;
        while(i<str.length()){
            int count=1;
            ans.append(str.charAt(i));
            while( i < str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                ans.append(count);
            }
            i++;
        }
        System.out.println(ans);
    }
    public static void stringAnna(String str1,String str2){
        if(str1.length()!=str2.length()){
            System.out.println("String are not anagram ");
            return;
        }
        str1= str1.toLowerCase();
        str2 = str2.toLowerCase();
        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2)){
            System.out.println("String are anagram");
        }
        else{
            System.out.println("String are not anagram ");
        }
    }
    public static void main(String[] args) {
        // String str = "abcban";
        // isPalindrome(str);
        // String str = "NSNSNSNNEEE";
        // shortestPath(str);
        // String arr[] = {"fine","hii","hello"};
        // findMax(arr);
        // String str = "i am fine";
        // converter(str, new StringBuilder(""));
        // String str = "abbbbccc";
        // stringCompre(str, new StringBuilder(""));
        String str1 = "race";
        String str2 = "car";
        stringAnna(str1, str2);
    }
}
