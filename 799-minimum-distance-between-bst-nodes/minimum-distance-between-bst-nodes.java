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
    public int minDiffInBST(TreeNode root) {
        return inorder(root);
    }public int inorder(TreeNode node){
        if(node==null)return (int)1e9;
        int ans=(int)1e9;
        if(node.left!=null){
            int leftmin=inorder(node.left);
            ans=Math.min(ans,leftmin);
        }
        if(prev!=null){
            ans=Math.min(ans,node.val-prev.val);
        }
        prev=node;
        if(node.right!=null){
            int rightmax=inorder(node.right);
            ans=Math.min(ans,rightmax);
        }
        return ans;
    }
}