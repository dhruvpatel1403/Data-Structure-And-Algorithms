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
    public static void main(String[] args) {
        System.out.println(validPara("[[()({})]{}]"));
    }
}
