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
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer>set=new HashSet<>();
        helper(root,set);
        return set.size()==1;
    }public void helper(TreeNode root,Set<Integer>set){
        if(root==null)return ;
        helper(root.left,set);
        set.add(root.val);
        helper(root.right,set);
    }
}