package DivideAndConquer;

public class Sort {
    public static void quickSort(int arr[],int i,int j){
        if(i>=j){
            return;
        }
        int index=partition(arr,i,j);
        quickSort(arr, i, index-1);
        quickSort(arr, index+1, j);
    }
    public static int partition(int arr[],int si,int ei){
        int pivot = ei;
        int i=si-1;
        for(int j=si;j<=ei-1;j++){
            if(arr[pivot]>arr[j]){
                int temp=arr[j];
                arr[j] = arr[++i];
                arr[i] = temp;
            }
        }
        int temp = arr[ei];
        arr[ei] = arr[++i];
        arr[i] = temp;
        return i;
    }
    public static int serchinRotated(int arr[],int si,int ei,int target){ // O(logn)
        if(si>ei){
            System.out.println("number not found");
            return -1;
        }
        int mid =  si + (ei-si)/2;
        if(arr[mid]==target){
            return mid;
        }
        else if(arr[mid]>arr[si]){
            if(arr[si]<=target && target < arr[mid]){
                return serchinRotated(arr, si, mid-1, target);
            }
            else{
                return serchinRotated(arr, mid+1, ei, target);
            }
        }
        else{
            if(arr[mid]>target && target>=arr[ei]){
                return serchinRotated(arr, mid+1, ei, target);
            }
            else{
                return serchinRotated(arr, si, mid-1, target);
            }
        }
    }
    public static void majority(int arr[]){
        int max= arr[0];
        for(int i=1;i<arr.length;i++){
            max= Math.max(arr[i],max);
        }
        int freq[] = new int[max+1];
        for(int j=0;j<arr.length;j++){
            freq[arr[j]]++;
        }
        for(int k=0;k<freq.length;k++){
            if(freq[k] > arr.length/2){
                System.out.println("Majority Element is " + k);
            }
        }
    }
    public static void mergerSort(int arr[], int si,int ei){
        if(si>=ei){
            return;
        }
        int mid= si + (ei-si)/2;
        mergerSort(arr, si, mid);
        mergerSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k = 0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        for(int m=si, n=0;n<temp.length;m++,n++){
            arr[m] = temp[n];
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4,9,8,7};
        // quickSort(arr, 0, arr.length-1);
        
        // System.out.println(serchinRotated(arr, 0, arr.length, 3));
        // majority(arr);
        mergerSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
