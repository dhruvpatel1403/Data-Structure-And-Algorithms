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
    public static void maxSumPrefix(int arr[]){

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }

        int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];
                max_sum = Math.max(max_sum,sum);
            }
        }
        System.out.println(max_sum);
    }
    public static void kdanesAlgo(int arr[]){
        int sum=0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            max_sum = Math.max(sum,max_sum);
            sum = Math.max(sum,0);
        }
        System.out.println(max_sum);
    }
    public static void trappindWater(int arr[]){
        // leftmax

        int n=arr.length;
        int left[] = new int[n];
        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(arr[i],left[i-1]);
        }
        // rightmax
        int right[] = new int[n];
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(arr[i],right[i+1]);
        }
        // waterlevel
        // max trapped water
        int trappedWater = 0;
        for(int i=0;i<n;i++){
            trappedWater += (Math.min(left[i],right[i])) - arr[i];
        }
        System.out.println(trappedWater);
    }

    public static void buySell(int arr[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]-buyPrice>0){
                maxProfit=Math.max(arr[i]-buyPrice,maxProfit);
            }
            else{
                buyPrice = arr[i];
            }
        }
        System.out.println(maxProfit);
    }
    public int peakIndexInMountainArray(int[] arr) {
        int st = 1;
        int end = arr.length - 2;
        while(st <= end){
            int mid = st + (end - st)/2;
            if(arr[mid]> arr[mid-1] && arr[mid]> arr[mid+1]){
                return mid;
            }
            else if(arr[mid] > arr[mid-1]){
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int st = 0;
        int arr[] = nums;
        int end = nums.length - 1;
        while(st <= end){
            int mid = st + (end -st)/2;
            if(mid == 0 && nums[0] != nums[1]){
                return nums[0];
            }
            if(mid == nums.length-1 && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            if(mid % 2 == 0){
                if(nums[mid-1]==nums[mid]){
                    end = mid-1;
                }
                else{
                    st = mid+1;
                }
            }
            else{
                if(nums[mid-1]==nums[mid]){
                    st = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }

        return -1;
    }
    public static void main(String args[]){
        int arr[] = {7,1,5,3,6,4};
        // search(arr, 0, 0);
        // binarySearch(arr, 2);
        // reverseArray(arr);
        // printArray(arr);
        // pairsInArray(arr);
        // printSubArray(arr);
        subArraySum(arr);
        maxSumPrefix(arr);
        kdanesAlgo(arr);
        trappindWater(arr);
        buySell(arr);
    }
}