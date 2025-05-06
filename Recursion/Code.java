public class Code {
    public static void printInDec(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printInDec(n-1);
    }
    public static void printInInc(int n){
        if(n==0){
            return;
        }
        printInInc(n-1);
        System.out.println(n);
    }
    public static int findFact(int n){
        if(n==1){
            return 1;
        }
        return n*findFact(n-1);
    }
    public static void main(String[] args) {
        // printInDec(5);
        // printInInc(5);
        System.out.println(findFact(5));
    }
}
