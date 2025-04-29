package bit;
public class Bits {
    public static void fastExpo(int a,int n){
        int ans=1;
        while(n>0){
            if((n & 1) != 0){
                ans = ans * a;
            }
            a =a * a;
            n = n>>1;
        }
        System.out.println(ans);
    }
    public static void fastExpoRec(int a,int n,int ans){
       if(n<=0){
            System.out.println(ans);
            return;
       } 
       else if((n & 1) != 0){
            ans = ans * a;
       }
       a = a*a;
       n=n>>1;
       fastExpoRec(a,n,ans);
    }
    public static void countBits(int n,int count){
        if(n <= 0){
            System.out.println(count);
            return;
        }
        else if(( n & 1) != 0){
            count++;
        }
        n = n>>1;
        countBits(n,count);
    }
    public static void clearLastIth(int n,int i){
        int bitMask = (-1) << i;
        System.out.println((n & bitMask));
    }
    public static void clearinRange(int n,int i,int j){
        int bitMask = ((-1) << (j+1)) | ((1<<i) - 1);
        System.out.println((n & bitMask));
    }
    public static void main(String args[]){
        // fastExpo(5,3);
        // fastExpoRec(5,3,1);
        countBits(15,0);
        clearLastIth(16,5);
        clearinRange(16,1,3);
    }
}
