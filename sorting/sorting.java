package sorting;

public class sorting {
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            boolean isSorted = false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = true;
                }
            }
            if(isSorted == false){
                break;
            }
        }
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minPos = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    public static void countSort(int arr[]){
        int max= arr[0];
        for(int i=1;i<arr.length;i++){
            if (arr[i]>max) {
                max=arr[i];
            }
        }
        int count[] = new int[max+1];
        for(int j=0;j<arr.length;j++){
            count[arr[j]]++;
        }
        int a=0;
        for(int k=0;k<count.length;k++){
            while(count[k] > 0){
                arr[a] = k;
                count[k]--;
                a++;
            }
        }
    }
    public static void quickSort(int array[],int st,int end){
        if(st>=end){
            return;
        }
        int pivot = recPart(array, st, end,st,st);
        quickSort(array, st, pivot-1);
        quickSort(array, pivot+1, end);
    }
    public static int recPart(int arr[],int st,int end,int i,int j){
        if(j>=end){
            int temp = arr[end];
            arr[end] = arr[i];
            arr[i] = temp;
            return i;
        }
        if(arr[j] < arr[end]){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
        return recPart(arr, st, end, i, j+1);
    }
    public static void inversionCount(int arr[]){
        int count=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void merrgeSort(int arr[],int st,int end,int count){
        if(st>=end){
            return;
        }
        int mid=st+(end-st)/2;
        merrgeSort(arr, st, mid,count);
        merrgeSort(arr, mid+1, end,count);
        merge(arr,st,mid,end);
    }
    public static void printBinary(int n,String st,int lastPlace){
        if(n==0){
            System.out.println(st);
            return;
        }
        printBinary(n-1, st+"0", 0);
        if(lastPlace==0){
            printBinary(n-1, st+"1", 1);
        }
    }
    public static void count(int arr[],int key,int i,int count){
        if(i==arr.length){
            // System.out.println(count);
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
            count++;
        }
        count(arr, key, i+1, count);
    }
    public static void convertToEnglish(int n,String arr[]){
        if(n<=0){
            return;
        }
        int lastElement = n%10;
        n=n/10;
        convertToEnglish(n, arr);
        System.out.print(arr[lastElement]+" ");
        
    }
    public static void string(String str,String sub,int n,int choice,int count){
        if(n==str.length()){
            if(sub.length() >= 1 && sub.charAt(0) == sub.charAt(sub.length()-1)){
                System.out.println(sub);
                count++;
                System.out.println(count);
            }
            return;
        }
        string(str, sub+Character.toString(str.charAt(n)), n+1,1,count);
        string(str, sub, n+1, 0,count);
    }
    public static void addElement(int arr[],int i){
        if(i==arr.length){
            return;
        }
        arr[i] = i+1;
        addElement(arr, i+1);
        arr[i] -=2;
    }
    public static void printSubsets(String str,int i, StringBuilder sub){
        if(i==str.length()){
            System.out.println(sub);
            return;
        }
        printSubsets(str, i+1, sub.append(str.charAt(i)));
        sub.deleteCharAt(sub.length()-1);
        printSubsets(str, i+1, sub);
    }
    public static void stringPermutation(String str,int i,String per){
        if(str.length() == 0){
            System.out.println(per);
            return;
        }
        for(int j=0;j<str.length();j++){
            String newstr = str.substring(0, j) + str.substring(j+1);
            stringPermutation(newstr, i-1, per+str.charAt(j));
        }
    }
    public static void printSubarray(int arr[],int i,int subArr[],int j){
        if(i==arr.length){
            printArray(subArr, 0);
            System.out.println();
            return;
        }
        subArr[j++] = arr[i];
        printSubarray(arr, i+1, subArr,j);
        printSubarray(arr, i+1, subArr, j);
    }
    
    public static void printArray(int arr[],int i){
        if(i==arr.length){
            return;
        }
        System.out.print(arr[i]+" ");
        printArray(arr, i+1);
    }
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        String arr[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // bubbleSort(array);
        // selectionSort(array);
        // countSort(array);
        // quickSort(array, 0, array.length-1);
        // for(int i=0;i<array.length;i++){
        //     System.out.print(array[i] + " ");
        // }
        // inversionCount(array);
        // printBinary(2, "", 0);
        // count(array, 2, 0, 0);
        // convertToEnglish(1994, arr);
        // string("aba", "", 0,0,0);
        // addElement(array, 0);
        // for(int i=0;i<array.length;i++){
        //         System.out.print(array[i] + " ");
        // }
        // printSubsets("abc", 0, new StringBuilder(""));
        String str = "abc";
        stringPermutation(str, str.length(),"");
        // printArray(array, 0);
        // printSubarray(array, 0, new int[5], 0);
    }
}
