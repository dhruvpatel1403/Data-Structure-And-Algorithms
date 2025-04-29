package BackTracking;

public class Abc {
    public static void printArr(char arr[][]){
        System.out.println("------- Chess Board -------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]!='Q'){
                    System.out.print("X ");
                }
                else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
    public static boolean isSafe(char arr[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(arr[i][col]=='Q'){
                return false;
            }
        }
        for(int j=col-1;j>=0;j--){
            if(arr[row][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
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
    public static void nQueens(char arr[][],int row){
        if(row>=arr.length){
            printArr(arr);
            count++;
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr, row, col)){
                arr[row][col] = 'Q';
                nQueens(arr, row+1);
                arr[row][col] = 'X';
            }
        }
    }
    public static boolean nQueensCheck(char arr[][],int row){
        if(row>=arr.length){
            return true;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr, row, col)){
                arr[row][col] = 'Q';
                if(nQueensCheck(arr, row+1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static int gridWays(int n,int m,int i, int j){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>n-1 || j>m-1){
            return 0;
        }
        return gridWays(n, m, i+1, j)+gridWays(n, m, i, j+1);
    }
    public static void printArr(int arr[][]){
        System.out.println("------- Sudoku -------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){ 
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static Boolean sudoku(int arr[][],int row,int col){
        //Base case
        if(col==arr[0].length){
            row++;
            col=0;
        }
        if(row==arr.length){
            printArr(arr);
            return true;
        }
        //Recursive call
        if(arr[row][col] != 0){
            return sudoku(arr, row, col+1);
        }
        else{
            for(int digit=1;digit<=9;digit++){
                if(isSafeSudoku(arr,row,col,digit)){
                    arr[row][col] = digit;
                    if(sudoku(arr, row, col+1))
                    {
                        return true;
                    }
                    arr[row][col] = 0;
                }
            }
        }
        return false;
    }
    public static boolean isSafeSudoku(int arr[][],int row,int col,int digit){
        for(int i=0;i<9;i++){
            if(arr[i][col]==digit || arr[row][i]==digit){
                return false;
            }
        }
        row=(row/3)*3;
        col=(col/3)*3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(arr[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    static int count=0;
    public static void main(String[] args) {
        int n=3;
        char arr[][] = new char[n][n];
        // nQueens(arr,0);
        // System.out.println("Total Possible solutions : "+count);
        // if(nQueensCheck(arr, 0)){
        //     System.out.println("Possible");
        //     printArr(arr);
        // }
        // else{
        //     System.out.println("Not Possible");
        // }
        // System.out.println(gridWays(3, 3, 0, 0));
        int[][] sudokuBoard = {
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
        System.out.println(sudoku(sudokuBoard, 0, 0));
    }
}
