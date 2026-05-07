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
    TreeNode prev=null;
    int ans=(int)1e9;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }public void dfs(TreeNode root){
        if(root==null)return;
        dfs(root.left);
        if(prev!=null){
            ans=Math.min(ans,root.val-prev.val);
        }
        prev=root;
        dfs(root.right);
    }
}