package Tries;

public class Code3 {
    static class Node{
        Node[] children  = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]== null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = false;
    }
    
    public static void main(String[] args) {
        String[] res = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<res.length;i++){
            insert(res[i]);
        }
    }
}
