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
    public int pathSum(TreeNode root, int targetsum) {
        if(root==null) return 0;
        helper(root,targetsum,0);
        pathSum(root.left,targetsum);
        pathSum(root.right,targetsum);
        return count;
    }public void helper(TreeNode node,int targetsum,long currsum){
        if(node==null)return ;
        currsum+=node.val;
        if(currsum==targetsum)count++;
        helper(node.left,targetsum,currsum);
        helper(node.right,targetsum,currsum);
    }
}