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
    public int rob(TreeNode root) {
        int[]choices=helper(root);
        return Math.max(choices[0],choices[1]);
    }private int[]helper(TreeNode node){
        if(node==null)return new int[2];
        int[]leftchoice=helper(node.left);
        int[]rightchoice=helper(node.right);
        int[]choices=new int[2];
        choices[0]=node.val+leftchoice[1]+rightchoice[1];
        choices[1]=Math.max(leftchoice[0],leftchoice[1])+Math.max(rightchoice[0],rightchoice[1]);
        return choices;
    }
}