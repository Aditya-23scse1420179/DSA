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
    public int goodNodes(TreeNode root) {
        return helper(root,-(int)1e9);
    }public int helper(TreeNode node,int max){
        if(node==null)return 0;
        int count=0;
        if(node.val>=max)count++;
        max=Math.max(node.val,max);
        count+=helper(node.left,max);
        count+=helper(node.right,max);
        return count;
    }
}