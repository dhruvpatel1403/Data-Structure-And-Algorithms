
public class Code3 {
    public static void printDec(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    public static void printInc(int n){
        if(n==0){
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    public static int findFact(int n){
        if(n==1){
            return 1;
        }
        return n * findFact(n-1);
    }
    public static int sumOfN(int n){
        if(n==0){
            return 0;
        }
        return n + sumOfN(n-1);
    }
    public static int findFirstOcc(int arr[],int ind,int key){
        if(ind == arr.length){
            return -1;
        }
        if(arr[ind] == key){
            return ind;
        }
        return findFirstOcc(arr, ind++, key);
    }
    public static void main(String[] args) {
        printDec(5);
        System.out.println();
        printInc(5);
        System.out.println();
        System.out.println(findFact(5));
        System.out.println(sumOfN(5));
    }
}
