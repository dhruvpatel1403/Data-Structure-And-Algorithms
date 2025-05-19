package QueueDS;
public class Codep {
    static class Queue{
        static int array[];
        static int size;
        static int rear;
        public Queue(int n){
            array = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static boolean isFull(){
            return rear == size-1;
        }
        public static void add(int val){
            if(isFull()){
                System.out.println("Queue is already full");
                return;
            }
            rear++;
            array[rear] = val;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Array is already empty");
                return -1;
            }
            int val = array[0];
            for(int i=0;i<array.length-1;i++){
                array[i] = array[i+1];
            }
            rear--;
            return val;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(5);
        q.add(6);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
