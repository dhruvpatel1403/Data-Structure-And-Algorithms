package DivideAndConquer;

public class Code {
    public static void serchInRotated(int arr[],int st,int end,int target){
        if(st>end){
            System.out.println("Element Not found");
            return;
        }
        int mid = st + (end-st)/2;
        if(arr[mid] == target){
            System.out.println("Element Found at "+ mid);
            return;
        }
        else if(arr[st]<=arr[mid]){
            if(arr[st]<=target && target<arr[mid]){
                serchInRotated(arr, st, mid-1, target);
            }
            else{
                serchInRotated(arr, mid+1, end, target);
            }
        }
        else{
            if(arr[mid]<target && target<=arr[end]){
                serchInRotated(arr, mid+1, end, target);
            }
            else{
                serchInRotated(arr, st, mid-1, target);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        serchInRotated(arr, 0, arr.length-1, target);
    }
}
