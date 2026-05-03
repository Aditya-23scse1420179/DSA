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
    public int getMinimumDifference(TreeNode root) {
        return inorder(root);
    }public int inorder(TreeNode root){
        int ans=(int)1e9;
        if(root==null)return ans;
        if(root.left!=null){
            int left=inorder(root.left);
            ans=Math.min(ans,left);
        }
        if(prev!=null){
            ans=Math.min(ans,root.val-prev.val);
        }
        prev=root;
        if(root.right!=null){
            int right=inorder(root.right);
            ans=Math.min(ans,right);
        }
        return ans;
    }
}