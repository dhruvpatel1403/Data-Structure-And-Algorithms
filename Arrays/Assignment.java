package Arrays;

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
    public static void main(String[] args) {
        int arr[] = { 1,1,1,2,2,2,3};
        System.out.println(isTwice(arr));
    }    
    
}
