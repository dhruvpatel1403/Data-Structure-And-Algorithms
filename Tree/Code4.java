package Tree;

import java.util.*;

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
    public static int idx = -1;
    public static Node buildetree(int arr[]){
        idx++;
        if(arr[idx] == -1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildetree(arr);
        newNode.right = buildetree(arr);
        return newNode;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }

    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr  = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        return lc + rc + 1;
    }
    public static int  sumNodes(Node root){
        if(root == null){
            return 0;
        }
        int ls = sumNodes(root.left);
        int rs = sumNodes(root.right);
        return ls + rs + root.data;
    }
    static class DiaInfo{
        int hg;
        int d;
        public DiaInfo(int hg,int d){
            this.hg = hg;
            this.d = d;
        }
    }
    public static DiaInfo diameter(Node root){
        if(root == null){
            return new DiaInfo(0, 0);
        }
        DiaInfo leftInfo = diameter(root.left);
        DiaInfo rightInfo = diameter(root.right);
        int hg = Math.max(leftInfo.hg, rightInfo.hg) + 1;
        int d =  Math.max(Math.max(leftInfo.d,rightInfo.d),leftInfo.hg+rightInfo.hg);
        return new DiaInfo(hg, d);
    }
    public static boolean isSubTree(Node root,Node subroot){
        if(root == null){
            return false;
        }
        if(root.data == subroot.data){
            if(isSubTreeHelper(root,subroot)){
                return true;
            }
        }
        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }
    public static boolean isSubTreeHelper(Node root,Node subroot){
        if(root == null && subroot == null){
            return true;
        }
        else if(root == null || subroot == null || root.data != subroot.data){
            return false;
        }
        return isSubTreeHelper(root.left, subroot.left) && isSubTreeHelper(root.right, subroot.right);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildetree(arr);
        // preorder(root);
        // System.out.println();
        // inOrder(root);
        // System.out.println();
        // levelOrder(root);
        // System.out.println(height(root));
        // System.out.println(countNodes(root));
        // System.out.println(sumNodes(root));
        // System.out.println(diameter(root).d);
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        System.out.println(isSubTree(root, subroot));
    }
}
