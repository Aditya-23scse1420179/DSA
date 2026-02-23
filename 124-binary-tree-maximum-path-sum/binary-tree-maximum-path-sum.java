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
    int max=-(int)1e9;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }public int helper(TreeNode root){
        if(root==null)return 0;
        int left=helper(root.left);
        if(left<0){
            left=0;
        }
        int right=helper(root.right);
        if(right<0){
            right=0;
        }
        max=Math.max(max,(left+right+root.val));
        return Math.max(left,right)+root.val;
    }
}