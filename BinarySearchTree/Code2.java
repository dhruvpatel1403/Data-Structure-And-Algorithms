package BinarySearchTree;
import java.util.*;
public class Code2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node balancedBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid = st + (end - st)/2;
        Node root = new Node(arr[mid]);
        root.left = balancedBST(arr, st, mid-1);
        root.right = balancedBST(arr, mid+1, end);
        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void inOrderArray(Node root,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        inOrderArray(root.left,list);
        list.add(root.data);
        inOrder(root.right);
    }
    static class Info{
        int max;
        int min;
        int size;
        boolean isValid;
        public Info(boolean isValid,int size,int min,int max){
            this.isValid = isValid;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxSize = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left= largestBST(root.left);
        Info right = largestBST(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(root.data,Math.min(left.min,right.min));
        int max = Math.max(root.data,Math.max(left.max,right.max));

        if(root.data <= left.max || root.data >= right.min){
            return new Info(false,size,min,max);
        }
        if(left.isValid && right.isValid){
            maxSize = Math.max(maxSize,size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};

        // Node root = balancedBST(arr,0,arr.length-1);
        // inOrder(root);
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        Info res = largestBST(root);
        System.out.println(maxSize);
    }
}
