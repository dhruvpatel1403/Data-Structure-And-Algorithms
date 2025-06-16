package Tree;
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
    static int idx = -1;
    public static Node buildTree(int arr[]){
        
        idx++;

        if(arr[idx] == -1){
            return null;
        }
        
        Node curr = new Node(arr[idx]);
        curr.left = buildTree(arr);
        curr.right = buildTree(arr);
        return curr;
    }
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
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
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
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
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return (ls + rs + root.data);
    }
    static class DiaInfo{
        int h;
        int d;
        public DiaInfo(int h,int d){
            this.h = h;
            this.d = d;
        }
    }
    public static DiaInfo diameter(Node root){
        if(root == null){
            return new DiaInfo(0, 0);
        }
        DiaInfo left = diameter(root.left);
        DiaInfo right = diameter(root.right);

        int h = Math.max(left.h, right.h)+1;
        int d = Math.max(Math.max(left.d,right.d),left.h+right.h+1);

        return new DiaInfo(h, d);
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        preOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println(height(root));
        System.out.println(countNodes(root));
        System.out.println(sum(root));
        System.out.println(diameter(root).d);
    }
}
