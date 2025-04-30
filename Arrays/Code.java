package Arrays;
public class Code{
    public static void search(int arr[],int n,int key){
        if(n==arr.length){
            System.out.println("Element not found");
            return;
        }
        if(arr[n]==key){
            System.out.println("ELement found at : "+n);
            return;
        }
        search(arr, n+1, key);
    }
    public static void binarySearch(int arr[],int target){
        int si = 0;
        int ei = arr.length-1;
        
        while(si<=ei){
            int mid= si + (ei-si)/2;
            if(arr[mid]==target){
                System.out.println("ELement Found at : "+mid);
                return;
            }
            else if(arr[mid]>target){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        System.out.println("Element Not Found");
    }
    public static void reverseArray(int arr[]){
        int si=0;
        int ei = arr.length-1;
        while(si<ei){
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void printSubArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void pairsInArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print(" ( "+arr[i]+" , "+ arr[j]+" )");
            }
            System.out.println();
        }
    }
    public static void subArraySum(int arr[]){
        int max_sum = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                max_sum = Math.max(max_sum,sum);
            }
        }
        System.out.println("Maximum Sub array sum is : "+max_sum);
    }
    public static void main(String args[]){
        int arr[] = {-1,2,-3,4,5};
        // search(arr, 0, 0);
        // binarySearch(arr, 2);
        // reverseArray(arr);
        // printArray(arr);
        // pairsInArray(arr);
        // printSubArray(arr);
        subArraySum(arr);
    }
}