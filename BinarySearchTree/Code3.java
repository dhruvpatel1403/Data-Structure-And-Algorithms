package BinarySearchTree;

public class Code3 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildTree(int val,Node root){
        if(root == null){
            return new Node(val);
        }
        else if(root.data > val){
            root.left = buildTree(val, root.left);
        }
        else{
            root.right = buildTree(val, root.right);
        }
        return root;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node root= null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(arr[i],root);
        }
        inOrder(root);
        System.out.println();
        System.out.println(serch(7, root));
        printInRange(root, 3, 5);
    }
}
