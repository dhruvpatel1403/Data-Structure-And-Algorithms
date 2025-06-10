package DynamicProgramming;
public class Code {
    public static int fib(int n,int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fib(n-1, f) + fib(n-2, f);
        return f[n];
    }
    public static int fibTabulation(int n){
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    public static void main(String[] args) {
        int n= 10;
        int f[] = new int[n+1];
        System.out.println(fib(n,f));
        System.out.println(fibTabulation(10));  
    }
}
