import java.util.*;
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
        return findFirstOcc(arr, ind+1, key);
    }
    public static int lastOccu(int arr[],int ind,int key){
        if(ind == arr.length){
            return -1;
        }
        int found = lastOccu(arr, ind+1, key);
        if(found != -1){
            return found;
        }
        if(arr[ind] == key){
            return ind;
        }
        return found;
    }
    public static void remveDup(String str,int ind,boolean arr[],StringBuilder ans){
        if(ind == str.length()){
            System.out.println(ans);
            return;
        }
        char curr = str.charAt(ind);
        if(arr[curr - 'a'] == true){
            remveDup(str, ind+1, arr, ans);
        }else{
            ans.append(curr);
            arr[curr-'a'] = true;
            remveDup(str, ind+1, arr, ans);
        }
        }
        public static int frdPair(int n){
            if(n == 1 || n == 2){
                return n;
            }
            return frdPair(n-1) + (n-1) * frdPair(n-2);
        }
        public static void printBSt(int n,int last,String str){
            if(n == 0){
                System.out.println(str);
                return;
            }
            printBSt(n-1, 0, str+"0");
            if(last == 0){
                printBSt(n-1, 1, str+"1");
            }
        }
        public static void printsubSet(String str,String ans,int ind){
            if(ind == str.length()){
                System.out.println(ans);
                return;
            }
            printsubSet(str, ans+str.charAt(ind), ind+1);
            printsubSet(str, ans, ind+1);
        }
//         public static void permutation(String str, String ans) {
//     if (ans.length() == str.length()) {
//         System.out.println(ans);
//         return;
//     }

//     HashSet<Character> used = new HashSet<>();

//     for (int i = 0; i < str.length(); i++) {
//         char curr = str.charAt(i);
//         if (used.contains(curr)) continue; // Skip duplicates
//         used.add(curr);

//         String newStr = str.substring(0, i) + str.substring(i + 1);
//         permutation(newStr, ans + curr);
//     }
// }
    public static void nQueens(int n,char arr[][],int row){
        if(row == arr.length){
            printArr(arr);
            System.out.println();
            count++;
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr,row,col)){
                arr[row][col] = 'Q';
                nQueens(n, arr, row+1);
                arr[row][col] = 'X';
            }
        }
    }
    public static void printArr(char arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] != 'Q'){
                    System.out.print("X ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char arr[][],int row,int col){
        for(int i=0;i<row;i++){
            if(arr[i][col]=='Q'){
                return false;
            }
        }
        for(int j=0;j<col;j++){
            if(arr[row][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&& j>=0; i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static int count=0;
    public static void main(String[] args) {
        // printDec(5);
        // System.out.println();
        // printInc(5);
        // System.out.println();
        // System.out.println(findFact(5));
        // System.out.println(sumOfN(5));
        // int arr[] = { 5,5,5,5};
        // System.out.println(findFirstOcc(arr, 0, 5));
        // System.out.println(lastOccu(arr, 0, 5));
        // remveDup("appnacollege", 0, new boolean[26], new StringBuilder(""));
        // System.out.println(frdPair(3));
        // printBSt(3, 0, "");
        // printsubSet("abc", "", 0);
        // permutation("abcd", "");
        int n=7;
        nQueens(n, new char[n][n], 0);
        System.out.println(count);
    }
}
