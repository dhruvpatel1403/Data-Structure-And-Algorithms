package sorting;

public class Assignment {
    public static void bubbleSort(int arr[]){
        Boolean swap=false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void countingSort(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int freq[] = new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<freq.length;i++){
            while(freq[i]>0){
                arr[j++] = i;
                freq[i]--;
            }
        }
    }
    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev=i-1;
            while(prev >= 0 && arr[prev]>curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]= {12,12,3,2,3,1};
        // bubbleSort(arr);
        // selectionSort(arr);
        // countingSort(arr);
        insertionSort(arr);
        printArr(arr);
    }
}
