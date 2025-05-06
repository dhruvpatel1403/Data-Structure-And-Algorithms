public class Code {
    public static void printInDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printInDec(n-1);
    }
    public static void main(String[] args) {
        printInDec(5);
    }
}
