/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)return root;
        connect(root.left);
        connect(root.right);
        Node tep1=root.left;
        Node tep2=root.right;
        while(tep1!=null){
            tep1.next=tep2;
            tep1=tep1.right;
            tep2=tep2.left;
        }
        return root;
    }
    
    
}