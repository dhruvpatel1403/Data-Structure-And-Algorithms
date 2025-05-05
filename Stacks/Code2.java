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
    public static void main(String[] args) {
        // System.out.println(validPara("[[()({})]{}]"));
        System.out.println(duplicate("((a+b)+(c+((d))))"));
    }
}
