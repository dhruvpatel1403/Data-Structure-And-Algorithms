package Arrays;
import java.util.Arrays;

public class Assignment {
    public static boolean isTwice(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(arr[i],max);
        }
        int freq[] = new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]>=2){
                return true;
            }
        }
        return false;
    }
    public static void searchInRotated(int arr[],int target,int si,int ei){
        if(si>ei){
            System.out.println("Element not found");
            return;
        }
        int mid  = si + (ei-si)/2;
        if(arr[mid]==target){
            System.out.println("Element found at : "+ mid);
            return;
        }
        else if(arr[mid]>=arr[si]){
            if(arr[si]<= target && target<arr[mid]){
                searchInRotated(arr, target, si, mid-1);
            }
            else{
                searchInRotated(arr, target, mid+1, ei);
            }
        }
        else{
            if(arr[mid]<target && target<=arr[ei]){
                searchInRotated(arr, target, mid+1, ei);
            }
            else{
                searchInRotated(arr, target, si, mid-1);
            }
        }
    }
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }

    public static void main(String[] args) {
        int arr[] = { 10,11,12,4,5,6};
        // System.out.println(isTwice(arr));
        searchInRotated(arr, 16, 0, arr.length-1);
        System.out.println(isAnagram("car","rac"));
    }    
    
}
