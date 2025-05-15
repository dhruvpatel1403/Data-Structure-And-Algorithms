package Stacks;
import java.util.*;

public class Code3 {
    public static void reverse(String str){
        StringBuilder ans = new StringBuilder("");
        Stack<Character> s= new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            s.push(curr);
        }
        while(!s.isEmpty()){
            ans.append(s.pop());
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        reverse("iamfine");
    }
}
