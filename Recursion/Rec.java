public class Rec {
    public static void printInDec(int n){
        if(n<0){
            return;
        }
        System.out.println(n);
        printInDec(n-1);
    }
    public static void printinInc(int n){
        if(n<0){
            return;
        }
        printinInc(n-1);
        System.out.println(n);
    }
    public static int findfact(int n){
        if(n==1){
            return 1;
        }
        return n*findfact(n-1);
    }
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    public static int nthFibonaci(int n){
        if(n==0 || n==1){
            return n;
        }
        return nthFibonaci(n-1)+nthFibonaci(n-2);
    }
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        else if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOccurance(int arr[],int target,int i){
        if(i==arr.length){
            System.out.println("element not found");
            return -1;
        }
        else if(arr[i]==target){
            return i;
        }
        else{
            return firstOccurance(arr, target, i+1);
        }
    }
    public static int lastOccurance(int arr[],int target,int i){
        if(i<0){
            System.out.println("Element not found");
            return -1;
        }
        else if(arr[i]==target){
            return i;
        }
        else{
            return lastOccurance(arr, target, i-1);
        }
    }
    public static void printAllOcc(int arr[],int target,int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==target){
            System.out.print(i+" ");
        }
        printAllOcc(arr, target, i+1);
    }
    public static int power(int n,int r){
        if(r==0){
            return 1;
        }
        return n*power(n, r-1);
    }
    public static int powerO(int n,int r){
        if(r==0){
            return 1;
        }
        
        int halfPower = powerO(n, r/2);
        int power = halfPower*halfPower;
        if(r%2 != 0){
            power = n*power;
        }
        return power;
    }
    public static void main(String[] args) {
        // printInDec(5);
        // printinInc(5);
        // System.out.println(findfact(5));
        // System.out.println(sum(5));
        // System.out.println(nthFibonaci(5));
        int arr[] = {2,2,1,4,2};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstOccurance(arr, 5, 0));
        // System.out.println(lastOccurance(arr, 1, arr.length-1));
        // printAllOcc(arr, 2, 0);
        // System.out.println(power(5, 3));
        System.out.println(powerO(5, 4));
    }
}
