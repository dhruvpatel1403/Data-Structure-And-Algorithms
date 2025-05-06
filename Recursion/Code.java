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
    public static int findSumOfN(int n){
        if(n==0){
            return 0;
        }
        return n + findSumOfN(n-1);
    }
    public static int findFirstOcc(int arr[],int target,int i){
        if(i==arr.length){
            System.out.println("Target not found in array");
            return -1;
        }
        if(arr[i]==target){
            System.out.println("Index is : "+i);
            return i;
        }
        return findFirstOcc(arr, target, i+1);
    }
    public static int findLastOcc(int arr[],int target,int i){
        if(i==-1){
            System.out.println("Target not found in array");
            return -1;
        }
        if(arr[i]==target){
            System.out.println("Index is : "+i);
            return i;
        }
        return findFirstOcc(arr, target, i-1);
    }
    public static int power(int x,int n){
        if(n==1){
            return x;
        }
        return x*power(x, n-1);
    }
    public static void main(String[] args) {
        // printInDec(5);
        // printInInc(5);
        // System.out.println(findFact(5));
        // System.out.println(findSumOfN(5));
        int arr[] = {1,4,5,2,12,3,2};
        // findFirstOcc(arr, 2, arr.length-1);
        System.out.println(power(5, 4));
    }
}
