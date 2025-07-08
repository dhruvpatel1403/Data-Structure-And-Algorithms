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
    public static int gridWays(int i,int j,int n,int m){
        if(i == n-1 && j== m-1){
            return 1;
        }
        else if(i == n || j == m){
            return 0;
        }
        int wr = gridWays(i+1, j, n, m);
        int wl = gridWays(i, j+1, n, m);
        return wr + wl;
    }
    public static boolean isSafeDigit(int arr[][],int row,int col,int digit){
        for(int i=0;i<arr.length;i++){
            if(arr[i][col] == digit || arr[row][i] == digit){
                return false;
            }
        }
        row = (row/3)* 3;
        col = (col/3) * 3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(arr[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku(int arr[][],int row,int col){
        if(col==arr[0].length){
            row++;
            col=0;
        }
        if(row==arr.length){
            return true;
        }
        if(arr[row][col] != 0){
            return sudoku(arr, row, col+1);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafeDigit(arr,row,col,digit)){
                arr[row][col]=digit;
                if(sudoku(arr, row, col+1)){
                    return true;
                }
                arr[row][col] = 0;
            }
        }
        return false;
    }
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if (sudoku(board, 0, 0)) {
            System.out.println("Sudoku solved!");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
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
        // nQueens(n, new char[n][n], 0);
        // System.out.println(count);
        // System.out.println(gridWays(0, 0, 3, 3));
    }
}
