package Arrays2D;

public class Code {
    public static void spiral(int arr[][]){
        int start_row = 0;
        int start_col = 0;
        int end_row = arr.length-1;
        int end_col = arr[0].length-1;
        while(start_row<end_row && start_col<end_col){
            for(int i=start_col;i<=end_col;i++){
                System.out.print(arr[start_row][i]+" ");
            }
            for(int i=start_row+1;i<=end_row;i++){
                System.out.print(arr[i][end_col]+" ");
            }
            if(start_row != end_row){
                for(int i=end_col-1;i>=start_col;i--){
                    System.out.print(arr[end_row][i]+" ");
                }
            }
            if(start_col != end_col){
                for(int i=end_row-1;i>=start_row+1;i--){
                    System.out.print(arr[i][start_col]+" ");
                }
            }
            start_row++;
            start_col++;
            end_col--;
            end_row--;
        }
        System.out.println();
    }
    public static void diagonal_sum(int arr[][]){
        // 1 2 3
        // 4 5 6
        // 7 8 9
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(arr.length-i-1 != i){
                sum+=arr[i][arr.length-i-1];
            }
        }
        System.out.println("Diagonal sum is : "+sum);
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{5,6,7},{9,10,11}};
        spiral(arr);
        diagonal_sum(arr);
    }
}
