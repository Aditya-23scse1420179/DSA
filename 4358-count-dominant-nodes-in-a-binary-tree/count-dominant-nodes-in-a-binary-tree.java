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
    int count=0;
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }public int dfs(TreeNode root){
        if(root==null)return -(int)1e9;
        int left=dfs(root.left);
        int right=dfs(root.right);
        if(root.val>=Math.max(left,right))count++;
        return Math.max(root.val,Math.max(left,right));
    }
}