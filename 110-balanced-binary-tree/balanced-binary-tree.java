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
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }public int helper(TreeNode root){
        if(root==null)return 0;
        int lefth=helper(root.left);
        int righth=helper(root.right);
        if(lefth==-1||righth==-1||Math.abs(lefth-righth)>1)return -1;
        return Math.max(lefth,righth)+1;
    }
}