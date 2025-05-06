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
    public static int powerOpti(int x,int n){
        if(n==1){
            return x;
        }
        int half = powerOpti(x, n/2);
        int powersq = half*half;
        if(n % 2 != 0){
            powersq = powersq * x;
        }
        return powersq;
    }
    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }
        return tilling(n-1)+tilling(n-2);
    }
    public static void removeDup(String str,int i,boolean arr[],StringBuilder ans){
        if(i==str.length()){
            System.out.println(ans);
            return;
        }
        if(!arr[str.charAt(i)-'a']){
            ans.append(str.charAt(i));
            arr[str.charAt(i)-'a'] = true;
        }
        removeDup(str, i+1, arr, ans);
    }
    public static int friendsPair(int n){
        if(n== 0 || n==1){
            return n;
        }
        return friendsPair(n-1)+(n-1)*friendsPair(n-2);
    }
    public static void main(String[] args) {
        // printInDec(5);
        // printInInc(5);
        // System.out.println(findFact(5));
        // System.out.println(findSumOfN(5));
        // 
        // findFirstOcc(arr, 2, arr.length-1);
        // System.out.println(powerOpti(5, 4));
        // System.out.println(tilling(4));
        // boolean arr[] = new boolean[26];
        // removeDup("helloiamfine", 0, arr, new StringBuilder(""));
        System.out.println(friendsPair(5));
    }
}
