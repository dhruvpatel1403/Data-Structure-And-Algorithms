package Tree;
import java.util.*;
public class Code2 {
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
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int arr[]){
            idx++;
            if(arr[idx] == -1){
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        }
        
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
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
            Queue<Node> q= new LinkedList<>();
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
                    System.out.print(curr.data+ " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
        public static int heightOfBT(Node root){
            if(root == null){
                return 0;
            }
            int lh = heightOfBT(root.left);
            int rh = heightOfBT(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int countNode(Node root){
            if(root == null){
                return 0;
            }
            int lc = countNode(root.left);
            int rc = countNode(root.right);
            return lc+rc+1;
        }
        public static int sumOfNode(Node root){
            if(root == null){
                return 0;
            }
            int ls = sumOfNode(root.left);
            int rs = sumOfNode(root.right);
            return ls+rs+root.data;
        }
        public static int diameterOfBT(Node root){
            if(root == null){
                return 0;
            }
            int ld = diameterOfBT(root.left);
            int rd = diameterOfBT(root.right);
            int lh = heightOfBT(root.left);
            int rh = heightOfBT(root.right);
            int selfD = lh+rh+1;
            return Math.max(Math.max(ld,rd),selfD);
        }
        static class DiaInfo{
            int height;
            int diameter;
            public DiaInfo(int h,int d){
                this.height = h;
                this.diameter = d;
            }
        }
        public static DiaInfo diaOpt(Node root){
            if(root == null){
                return new DiaInfo(0, 0);
            }
            DiaInfo left = diaOpt(root.left);
            DiaInfo right = diaOpt(root.right);
            int hg = Math.max(left.height,right.height)+1;
            int dia = Math.max(left.height+right.height+1,Math.max(left.diameter,right.diameter));
            return new DiaInfo(hg, dia);
        }
        public static boolean subTree(Node root,Node subroot){
            if(root == null){
                return false;
            }
            if(root.data == subroot.data){
                if(isSubTree(root, subroot)){
                    return true;
                }
            }
            return subTree(root.left, subroot) || subTree(root.right, subroot);
        }
        public static boolean isSubTree(Node root,Node subroot){
            if(root == null && subroot==null){
                return true;
            }
            else if(root == null || subroot == null || root.data != subroot.data){
                return false;
            }
            if(!isSubTree(root.left, subroot.left)){
                return false;
            }
            if(!isSubTree(root.right, subroot.right)){
                return false;
            }
            return true;
        }
        public static class TopInfo{
            int hd;
            Node root;
            public TopInfo(int hd,Node root){
                this.hd = hd;
                this.root = root;
            }
        }
        public static void TopView(Node root){
            // Level Order
            Queue<TopInfo> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();
            int min = 0,max = 0;
            q.add(new TopInfo(0,root));
            q.add(null);
            while(!q.isEmpty()){
                TopInfo curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd,curr.root);
                    }
                    if(curr.root.left != null){
                        q.add(new TopInfo(curr.hd-1, curr.root.left));
                        min = Math.min(min,curr.hd-1);
                    }
                    if(curr.root.right != null){
                        q.add(new TopInfo(curr.hd+1, curr.root.right));
                        max = Math.max(max,curr.hd+1);
                    }
                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }
        public static void lowestComAn(Node root,int n1,int n2){
            ArrayList<Integer> p1 = new ArrayList<>();
            ArrayList<Integer> p2 = new ArrayList<>();
            getPath(root,n1,p1);
            getPath(root,n2,p2);
            int i=0;
            for(;i<p1.size() && i<p2.size();i++){
                if(p1.get(i) != p2.get(i)){
                    break;
                }
            }
            System.out.println(p1.get(i-1));
        }
        public static boolean getPath(Node root,int n,ArrayList<Integer> p1){
            if(root == null){
                return false;
            }
            p1.add(root.data);
            if(root.data == n){
                return true;
            }
            boolean left = getPath(root.left, n, p1);
            boolean right = getPath(root.right, n, p1);
            if(left || right){
                return true;
            }
            p1.remove(p1.size()-1); 
            return false;  
        }
        public static Node lca(Node root,int n1,int n2){
            if(  root == null || root.data == n1 || root.data == n2 ){
                return root;
            }
            Node left = lca(root.left, n1, n2);
            Node right = lca(root.right, n1, n2);
            if(left == null){
                return right;
            }
            if(right == null){
                return left;
            }
            return root;
        } 
    }
    
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // System.out.println(tree.heightOfBT(root));
        // System.out.println(tree.countNode(root));
        // System.out.println(tree.sumOfNode(root));
        // System.out.println(tree.diameterOfBT(root));
        // System.out.println(tree.diaOpt(root).diameter);
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        // subroot.left.left = new Node(8);
        // System.out.println(tree.isSubTree(root, subroot));
        // tree.TopView(root);
        tree.lowestComAn(root, 4, 5);
        System.out.println(tree.lca(root,4,5).data);
    }
}
