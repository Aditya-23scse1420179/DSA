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
    int cam=0;
    public int minCameraCover(TreeNode root) {
        if(helper(root)==0)cam++;
        return cam;
    }public int helper(TreeNode node){
        if(node ==null)return 2;//covered
        int left=helper(node.left);
        int right=helper(node.right);
        if(left==0||right==0){//not covered
            cam++;
            return 1;
        }
        if(left==1||right==1)return 2; //placed
        return 0;
    }
}