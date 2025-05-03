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
    public static void main(String[] args) {
        clearIthBit(16, 4);
    }
}
