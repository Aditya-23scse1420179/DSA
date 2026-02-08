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
    static boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced=true;
        helper(root);
        return balanced;
    }public int helper(TreeNode root){
        if(root==null)return 0;
        int lefth=helper(root.left);
        int righth=helper(root.right);
        if(Math.abs(lefth-righth)>1)balanced= false;;
        return Math.max(lefth,righth)+1;
    }
}