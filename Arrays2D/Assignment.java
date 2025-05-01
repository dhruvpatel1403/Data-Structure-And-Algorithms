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
    public static void main(String[] args) {
        int arr[][] = {{1,7,9},{8,8,7}};
        count7(arr);
    }
}
