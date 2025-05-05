package Stacks;
import java.util.*;
public class Code2 {
    public static Boolean validPara(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            //opening
            if(curr == '(' || curr == '{' || curr== '['){
                s.push(curr);
            }
            //clossing
            else{
                if(s.isEmpty()){
                    return false;
                }
                else if(curr == ')' && s.peek() == '(' || curr == '}' && s.peek() == '{' || curr == ']' && s.peek() == '['){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!s.isEmpty()){
            return false;
        }
        return true;

    }
    public static boolean duplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //clossing
            if(ch == ')'){
                int count = 0;
                while( s.peek() != '('){
                    s.pop();
                    count++;
                } 
                if(count<1){
                    return true;
                }
                s.pop();
            }
            //openning
            else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void findMaxArea(int arr[]){
        Stack<Integer> s = new Stack<>();
        int left[] = new int[arr.length];
        int right[] = new int[arr.length]; 
        int max_area = Integer.MIN_VALUE;
        //find next small right
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = arr.length;
            }
            else{
                right[i] = s.peek();
            }
            s.push(i);
        }

        //find next small left
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = s.peek();
            }
            s.push(i);
        }
        //find area
        for(int i=0;i<arr.length;i++){
            int wd = right[i] - left[i] -1;
            int area = arr[i] * wd;
            max_area = Math.max(max_area,area);
        }
        System.out.println("Max are : " + max_area);
    }
    public static void main(String[] args) {
        // System.out.println(validPara("[[()({})]{}]"));
        // System.out.println(duplicate("((a+b)+(c+((d))))"));
        int arr[] = {2,1,5,6,2,3};
        findMaxArea(arr);
    }
}
