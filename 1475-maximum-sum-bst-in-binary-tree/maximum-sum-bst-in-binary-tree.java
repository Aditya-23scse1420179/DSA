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
    int max=0;
    class pair{
        boolean bst;
        int min;
        int max;
        int sum;
        public pair(boolean bst,int min,int max,int sum){
            this.bst=bst;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }public pair dfs(TreeNode root){
        if(root==null)return new pair(true,(int)1e9,-(int)1e9,0);
        pair left=dfs(root.left);
        pair right=dfs(root.right);
        if(left.bst&&right.bst&&root.val>left.max&&root.val<right.min){
            int csum=root.val+left.sum+right.sum;
            max=Math.max(max,csum);
            return new pair(true,Math.min(root.val,left.min),Math.max(root.val,right.max),csum);
        }
        return new pair(false,0,0,0);
        
    }
}