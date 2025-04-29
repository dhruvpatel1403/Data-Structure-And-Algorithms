package Strings;

public class Strings {
    public static void stringCompre(String str,StringBuilder sb,int i){
        if(i >= str.length()){
            System.out.println(sb);
            return;
        }
        int count = 1;
        sb.append(str.charAt(i));
        while( i < str.length() -1 && str.charAt(i) == str.charAt(i+1)){
            count++;
            i++;
        }
        if(count>1){
            sb.append(count);
        }
        stringCompre(str, sb, ++i);
    }
    public static void converToUpper(String str,StringBuilder sb){
        sb.append(Character.toUpperCase(str.charAt(0)));
        for(int i=1;i<str.length();i++){
            sb.append(str.charAt(i));
            if(str.charAt(i)==' '){
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        System.out.println(sb);
    }
    public static void searchInRotatedArray(int arr[], int st, int ls, int target) {
        if (st > ls) {
            System.out.println("Element not found");
            return;
        }
        int mid = st + (ls - st) / 2;
        if (arr[mid] == target) {
            System.out.println("Element found at " + mid);
            return;
        }
        
        // If left half is sorted
        if (arr[st] <= arr[mid]) {
            if (target >= arr[st] && target < arr[mid]) {
                searchInRotatedArray(arr, st, mid - 1, target);
            } else {
                searchInRotatedArray(arr, mid + 1, ls, target);
            }
        }
        // Else right half must be sorted
        else {
            if (target > arr[mid] && target <= arr[ls]) {
                searchInRotatedArray(arr, mid + 1, ls, target);
            } else {
                searchInRotatedArray(arr, st, mid - 1, target);
            }
        }
    }
    public static void main(String[] args) {
        stringCompre("abcd", new StringBuilder(""), 0);
        converToUpper("hii i am fine", new StringBuilder(""));
        int array[] = {4,5,6,7,1,2,3};
        searchInRotatedArray(array, 0, array.length-1, 3);
    }
}
