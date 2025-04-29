package BackTracking;

public class Back {
    public static boolean isSafe(char arr[][],int i,int j){
        for(int a=i;a>=0;a--){
            if(arr[a][j]=='Q'){
                return false;
            }
        }
        for(int b=j;b>=0;b--){
            if(arr[i][b]=='Q'){
                return false;
            }
        }
        for(int a=i-1, b=j-1;a>=0 && b>=0;a--,b--){
            if(arr[a][b]=='Q'){
                return false;
            }
        }
        for(int a=i-1,b=j+1;a>=0 && b<arr[0].length;a--,b++){
            if(arr[a][b]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean nQueens(char arr[][],int row){
        if(row==arr.length){
            printArray(arr);
            count++;
            return true;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafe(arr, row, col)){
                arr[row][col] = 'Q';
                if(nQueens(arr, row+1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isSafeRepete(char arr[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(arr[i][col]=='Q'){
                return false;
            }
        }
        for(int j=col-1;j>=0;j--){
            if(arr[row][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<arr[0].length;i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static boolean nQueensRpeate(char arr[][],int row){
        if(row==arr.length){
            printArray(arr);
            count++;
            return true;
        }
        for(int col=0;col<arr.length;col++){
            if(isSafeRepete(arr,row,col)){
                arr[row][col] = 'Q';
                if(nQueensRpeate(arr, row+1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void printArray(char arr[][]){
        System.out.println("--------- Chess Board ---------");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j] != 'Q'){
                    System.out.print("x"+ " ");
                }
                else{
                    System.out.print(arr[i][j]+ " ");
                }
            }
            System.out.println();
        }
    }
    public static void printintArray(int arr[]){
        System.out.println("--------- Chess Board ---------");
        for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+ " ");
        }
        System.out.println();

    }
    public static void printRecArray(char arr[][], int row, int col) {
        if (row == arr.length) {     // end of current column
              // move to next column
            return;
        }
        if (col == arr[0].length) {
            printRecArray(arr, row+1, 0);
            return;  // all columns processed
        }
        
        System.out.print(arr[row][col]);
        printRecArray(arr, row, col+1);  // next row in same column
    }
    public static int waysGrid(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(i>=n || j>=m){
            return 0;
        }
        int ways=waysGrid(i+1,j,n, m)+waysGrid(i,j+1,m,n);
        return ways;
    }
    public static boolean isSafeDigit(int[][] arr, int row, int col, int digit) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == digit || arr[i][col] == digit) {
                return false;
            }
        }
        // Check 3x3 subgrid
        int subgridRow = (row / 3) * 3;
        int subgridCol = (col / 3) * 3;
        for (int i = subgridRow; i < subgridRow + 3; i++) {
            for (int j = subgridCol; j < subgridCol + 3; j++) {
                if (arr[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean sudoku(int[][] arr, int row, int col) {
        // Base case: puzzle solved
        if (row == 9) {
            return true;
        }
        // Move to next row if at end of column
        if (col == 9) {
            return sudoku(arr, row + 1, 0);
        }
        // Skip already filled cells
        if (arr[row][col] != 0) {
            return sudoku(arr, row, col + 1);
        }
        // Try digits 1-9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafeDigit(arr, row, col, digit)) {
                arr[row][col] = digit;
                if (sudoku(arr, row, col + 1)) {
                    return true;
                }
                // Backtrack if solution not found
                arr[row][col] = 0;
            }
        }
        return false;
    }
    public static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
                if (col == 2 || col == 5) System.out.print("| ");
            }
            System.out.println();
            if (row == 2 || row == 5) System.out.println("---------------------");
        }
    }
    static int count=0;
    public static void main(String[] args) {
        int n=5;
        char arr[][] = new char[n][n];
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
        // if(nQueens(arr,0)){
        //     System.out.println("possible");
        // }
        // else{
        //     System.out.println("not possible");
        // }
        // int arrr[] = {1,2,3,4};
        // nQueensRpeate(arr, 0);
        // printRecArray(arr, 0,0);
        // System.out.println(count);
        // System.out.println(waysGrid(0, 0, 4, 4));
        if (sudoku(sudokuBoard, 0, 0)) {
            System.out.println("Sudoku Solved!");
            printBoard(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }
    
    // Helper method to print the board
    
}
