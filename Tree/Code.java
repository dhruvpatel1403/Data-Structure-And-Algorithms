package Tree;
import java.util.*;
public class Code {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    static class BinnaryTree{
        static int idx = -1;
        public static Node buildeTree(int nodes[]){

            idx++;

            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildeTree(nodes);
            newNode.right = buildeTree(nodes);

            return newNode;
        }
        public static void preOrder(Node root){

            if(root == null){
                System.out.print(-1+" ");
                return;
            }

            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);

        }
        public static void inOrder(Node root){

            if(root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){

            if(root == null){
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
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
                    }else{
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
            int lh = countNodes(root.left);
            int rh = countNodes(root.right);
            return lh + rh + 1;   
        }
        public static int sumNodes(Node root){
            if(root == null){
                return 0;
            }
            int lh = sumNodes(root.left);
            int rh = sumNodes(root.right);
            return lh + rh + root.data;   
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int ld = diameter(root.left);
            int lh = height(root.left);
            int rh = height(root.right);
            int rd = diameter(root.right);
            return Math.max(Math.max(ld,rd),lh+rh+1);
        }
    //     public static boolean isSubTree(Node root,Node subroot){
    //         if(subroot == null){
    //             return true;
    //         }
    //         if(root == null){
    //             return false;
    //         }
    //         if(root.data == subroot.data){
    //             if(isIdentical(root,subroot)){
    //                 return true;
    //             }
    //         }
    //         return isSubTree(root.left, subroot.left) || isSubTree(root.right, subroot.right);
    //     }
    //     public static boolean isIdentical(Node node,Node subroot){
    //         if(node == null && subroot == null){
    //             return false;
    //         }
    //         else if(node == null || subroot == null || node.data != subroot.data){
    //             return false;
    //         }
    //         if(!isIdentical(node.left, subroot.left)){
    //             return false;
    //         }
    //         if(!isIdentical(node.right, subroot.right)){
    //             return false;
    //         }
    //         return true;
    // }
    public static boolean isSubTree(Node root, Node subroot) {
        if (subroot == null) {
            return true;  // An empty subtree is always a subtree
        }
        if (root == null) {
            return false;  // Main tree is empty but subtree is not
        }
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        // Check left and right subtrees (but keep subroot the same)
        return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }

    public static boolean isIdentical(Node node, Node subroot) {
        if (node == null && subroot == null) {
            return true;  // Both are null → identical
        }
        if (node == null || subroot == null) {
            return false;  // Only one is null → not identical
        }
        if (node.data != subroot.data) {
            return false;  // Data mismatch → not identical
        }
        // Recursively check left and right subtrees
        return isIdentical(node.left, subroot.left) && isIdentical(node.right, subroot.right);
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min = 0,max = 0;
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void printKthLevel(Node root,int k){
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        int i = 1;
        q.add(null);
        if(k==1){
            System.out.println(root.data);
            return;
        }
        else{
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                        i++;
                    }
                }else{
                    if(i==k){
                        System.out.print(curr.data+" ");
                    }
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
    }
    public static void kLevelRecursive(Node root,int k,int i){
        if(root == null){
            return;
        }
        if(i==k){
            System.out.print(root.data+" ");
            return;
        }
        kLevelRecursive(root.left, k, i+1);
        kLevelRecursive(root.right, k, i+1);
    }
    public static Node lca(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftlca = lca(root.left, n1, n2);
        Node rightlca = lca(root.right, n1, n2);
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }
        return root;
    }
    public static int minDist(Node root,int n1,int n2){
        Node lca = lca(root, n1, n2);
        int dis1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);
        return dis1+dist2;
    }
    public static int lcaDist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int l = lcaDist(root.left, n);
        int r = lcaDist(root.right, n);
        if( l == -1 && r == -1){
            return -1;
        }
        else if(l == -1){
            return r+1;
        }
        else{
            return l+1;
        }
    }
    public static int kthAncesster(Node root,int k,int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int l = kthAncesster(root.left, k, n);
        int r = kthAncesster(root.right, k, n);
        if(l == -1 && r == -1){
            return -1;
        }
        int max = Math.max(l,r);
        if(max+1 == k){
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int transFormSum(Node root){
        if(root == null){
            return 0;
        }
        int ls = transFormSum(root.left);
        int rs = transFormSum(root.right);
        int data = root.data;
        int left = root.left == null ? 0 : root.left.data;
        int right = root.right == null ? 0 : root.right.data;
        root.data = ls+ left + rs +right;
        return data;
    }
    public static int hBt(Node root){
        if(root == null){
            return 0;
        }
        int lh = hBt(root.left);
        int rh = hBt(root.right);
        return Math.max(lh,rh) +1;
    }
} 
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinnaryTree tree = new BinnaryTree();
        Node root  = tree.buildeTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // System.out.println();
        // System.out.println(tree.height(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumNodes(root));
        // System.out.println(tree.diameter(root));
        // Node subroot = new Node(2);
        // subroot.left = new Node(4);
        // subroot.right = new Node(5);
        // // subroot.left.left = new Node(8);
        // System.out.println(tree.isSubTree(root, subroot));
        // tree.topView(root);
        // tree.printKthLevel(root, 3);
        // Node tar = new Node(4);
        // tree.kLevelRecursive(root, 2, 1);
        // tree.kthAncesster(root, 2, tar, 0);
        // System.out.println(tree.lca(root, 4, 5).data);
        // System.out.println(tree.minDist(root, 4, 5));
        // tree.kthAncesster(root, 1, 4);
        tree.levelOrder(root);
        tree.transFormSum(root);
        tree.levelOrder(root);
    }
}
