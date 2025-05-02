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
    public static void main(String[] args) {
        String str = "abcban";
        isPalindrome(str);
    }
}
