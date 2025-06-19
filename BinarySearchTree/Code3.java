package BinarySearchTree;

import java.util.*;

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
    public static boolean serch(int val,Node root){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        else if(root.data > val){
            return serch(val, root.left);
        }
        else{
            return serch(val, root.right);
        }
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void printInRange(Node root,int n1,int n2){
        if(root == null){
            return;
        }
        if(root.data >= n1 && root.data <= n2){
            printInRange(root.left, n1, n2);
            System.out.print(root.data + " ");
            printInRange(root.right, n1, n2);
        }else if(root.data < n1){
            printInRange(root.right, n1, n2);
        }
        else{
            printInRange(root.left, n1, n2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" --> ");
        }
        System.out.println();
    }
    public static void path(Node root,ArrayList<Integer> path1){
        if(root == null){
            return;
        }
        path1.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path1);
        }
        path(root.left, path1);
        path(root.right, path1);
        path1.remove(path1.size()-1);
        
    }
    public static void main(String[] args) {
        int arr[] = {8,5,3,1,4,6,10,11,14};
        Node root= null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(arr[i],root);
        }
        // inOrder(root);
        // System.out.println();
        // System.out.println(serch(7, root));
        // printInRange(root, 3, 5);
        path(root, new ArrayList<Integer>());
    }
}
