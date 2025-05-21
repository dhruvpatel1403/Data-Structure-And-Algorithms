package BinarySearchTree;

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
    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
        Node root = balancedBST(arr,0,arr.length-1);
        inOrder(root);
    }
}
