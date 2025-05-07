package QueueDS;

public class Code {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is already full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }
        public static int remove(){
            if(rear == -1){
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }
        public static void peek(){
            if(rear == -1){
                System.out.println("Queue is empty");
                return;
            }
            System.out.println(arr[0]);
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            q.peek();
            q.remove();
        }
    }
}
