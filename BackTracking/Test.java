package BackTracking;

public class Test {
    public static boolean isSafe(char arr[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(arr[i][col]=='Q'){
                return false;
            }
        }
        for(int i=col-1;i>=0;i--){
            if(arr[row][i]=='Q'){
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
    public static boolean nQueens(char arr[][],int row){
        if(row==arr.length){
            count++;
            // printArr(arr);
            return true;
        }
        for(int i=0;i<arr.length;i++){
            if(isSafe(arr,row,i)){
                arr[row][i] = 'Q';
                if(nQueens(arr, row+1))
                {
                    return true;
                }
                // arr[row][i]='X';
            }
        }
        return false;
    }
    public static int gridWays(int m,int n,int i,int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        return gridWays(m, n, i+1, j) + gridWays(m, n, i, j+1);

    }
    static int count=0;
    public static void printArr(char arr[][]){
        System.out.println("----- Chess Board -----");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]=='Q'){
                    System.out.print(arr[i][j]+" ");
                }
                else{
                    System.out.print("X"+" ");
                }
                
            }
            System.out.println();
        }
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
    public static int ratInMaze(int arr[][],int i,int j,int m,int n,boolean visited[][]){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i >= m || j >= n || i < 0 || j < 0 || arr[i][j] == 0 || visited[i][j] == true){
            return 0;
        }
        
        int path=0;
        visited[i][j] = true;
        path+=ratInMaze(arr, i+1, j, m, n, visited);
        path+=ratInMaze(arr, i-1, j, m, n, visited);
        path+=ratInMaze(arr, i, j+1, m, n, visited);
        path+=ratInMaze(arr, i, j-1, m, n, visited);
        visited[i][j] = false;
        return path;
    }
    
    public static void main(String[] args) {
        // int n=5;
        // char arr[][] = new char[n][n];
        // if(nQueens(arr,0)){
        //     System.out.println("possible");
        //     // printArr(arr);
        // }
        // else{
        //     System.out.println("Not possible");
        // }
        // System.out.println("Total Possible solutions are : "+count);
        // System.out.println(gridWays(3, 3, 0, 0));
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
        // if (sudoku(board, 0, 0)) {
        //     System.out.println("Sudoku solved!");
        //     printBoard(board);
        // } else {
        //     System.out.println("No solution exists.");
        // }
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        int m = 4, n = 4;
        boolean[][] visited = new boolean[m][n];
        int pathCount = ratInMaze(maze, 0, 0, m, n, visited);
        System.out.println("Total unique paths: " + pathCount);  // Output: 2

        String arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    }
}
