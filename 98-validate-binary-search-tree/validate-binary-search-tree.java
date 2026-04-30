/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }public boolean helper(TreeNode node,TreeNode min,TreeNode max){
        if(node==null)return true;
        if(min!=null&&node.val<=min.val)return false;
        if(max!=null&&node.val>=max.val)return false;
        if(!helper(node.left,min,node))return false;
        if(!helper(node.right,node,max))return false;
        return true;
    }
}