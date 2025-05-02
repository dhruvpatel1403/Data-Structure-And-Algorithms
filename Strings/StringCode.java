package Strings;

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
    public static void main(String[] args) {
        // String str = "abcban";
        // isPalindrome(str);
        // String str = "NSNSNSNNEEE";
        // shortestPath(str);
        // String arr[] = {"fine","hii","hello"};
        // findMax(arr);
        String str = "i am fine";
        converter(str, new StringBuilder(""));
    }
}
