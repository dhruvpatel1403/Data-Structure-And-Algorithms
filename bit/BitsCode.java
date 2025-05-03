package bit;

public class BitsCode {

    public static void getIthBit(int number,int i){
        if((number & (1<<i)) != 0){
            System.out.println("Ith bit is 1");
        }
        else{
            System.out.println("Ith bit is 0");
        }
    }
    public static void setIthBit(int number, int i){
        System.out.println((number | (1<<i)));
    }
    public static void clearIthBit(int number,int i){
        System.out.println(number & (~(1<<i)));
    }
    public static void clearLastIthBit(int number,int i){
        // 11110000 --> ~1 << 4
        System.out.println(number & ((-1)<<i));
    }
    public static void clearInRange(int number,int i,int j){
        // 11100011 2,4 --> 11100000 | 00000011 --> -1 << j+1 | ~(-1<<i) 
        int bitmask = (-1 << (j+1)) | (~(-1<<i));
        System.out.println(number & bitmask);
    }
    public static void isPowerOf2(int number){
        if((number & (number-1)) == 0){
            System.out.println("Power of 2");
        }
        else{
            System.out.println("Not Power of 2");
        }
    }
    public static void main(String[] args) {
        // clearLastIthBit(15, 1);
        // clearInRange(15, 0, 3);
        isPowerOf2(15);
    }
}
