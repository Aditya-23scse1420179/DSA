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
    private int mindiff=(int)1e9;
    private Integer prevVal=null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return mindiff;
    }public void inorder(TreeNode node){
        if(node==null)return;
        inorder(node.left);
        if(prevVal!=null){
            mindiff=Math.min(mindiff,node.val-prevVal);
        }
        prevVal=node.val;
        inorder(node.right);
    }
}