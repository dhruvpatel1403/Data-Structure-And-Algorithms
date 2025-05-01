package Arrays2D;

public class Assignment {
    public static void count7(int arr[][]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] == 7){
                    count++;
                }
            }
        }
        System.out.println("Count of 7 is : "+count);
    }
    public static void sum2ndRow(int arr[][]){
        int sum=0;
        for(int i=0;i<arr[0].length;i++){
            sum+=arr[1][i];
        }
        System.out.println("Sum is : "+sum);
    }
    public static void findTranspose(int arr[][]){
        int transpose[][] =new int[arr[0].length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                transpose[j][i] = arr[i][j];
            }
        }
        print2D(transpose);
    }
    public static void print2D(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,7,9},{8,8,7}};
        // count7(arr);
        // sum2ndRow(arr);
        print2D(arr);
        findTranspose(arr);
    }
}
