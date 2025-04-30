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
    public static void main(String args[]){
        int arr[] = {1,9,3,5,8};
        search(arr, 0, 0);

    }
}