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
    class pair{
        TreeNode node;
        int sum;
        public pair(TreeNode node,int sum){
            this.node=node;
            this.sum=sum;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        Queue<pair>q=new LinkedList<>();
        q.offer(new pair(root,root.val));
        while(!q.isEmpty()){
            pair curr=q.poll();
            if(curr.node.left==null&&curr.node.right==null&&curr.sum==targetSum)return true;
            if(curr.node.left!=null)q.offer(new pair(curr.node.left,curr.sum+curr.node.left.val));
            if(curr.node.right!=null)q.offer(new pair(curr.node.right,curr.sum+curr.node.right.val));
        }
        return false;
    }
}