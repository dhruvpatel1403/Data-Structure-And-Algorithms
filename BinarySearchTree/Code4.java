package BinarySearchTree;

public class Code4 {
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
    public static Node buildTree(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = buildTree(root.left, val);
        }
        else if(root.data < val){
            root.right = buildTree(root.right, val);
        }
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(root, arr[i]);
        }
    }
}
