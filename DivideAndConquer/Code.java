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
    public static void quickSort(int arr[],int st,int end){
        if(st>=end){
            return;
        }
        int pivot = partition(arr,st,end);
        quickSort(arr, st, pivot-1);
        quickSort(arr, pivot+1, end);
    }
    public static int partition(int arr[],int st,int end){
        int i = st-1;
        int pivot = arr[end];
        for(int j=st;j<end;j++){
            if(arr[j]<=pivot){
                int temp = arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
        }
        int temp = arr[end];
        arr[end] = arr[++i];
        arr[i] = temp;
        return i;
    }
    public static void mergerSort(int arr[],int st,int end){
        if(st >= end){
            return;
        }
        int mid = st + (end-st)/2;
        mergerSort(arr, st, mid);
        mergerSort(arr, mid+1, end);
        merge(arr,st,end,mid);
    }
    public static void merge(int arr[],int st,int end,int mid){
        int temp[] = new int[end-st+1];
        int i = st;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=end){
            temp[k++] = arr[j++];
        }
        for(int l = 0,m=st ;l<k;l++,m++){
            arr[m] = temp[l];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        // int target = 0;
        // serchInRotated(arr, 0, arr.length-1, target);
        // quickSort(arr, 0, arr.length-1);
        mergerSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
