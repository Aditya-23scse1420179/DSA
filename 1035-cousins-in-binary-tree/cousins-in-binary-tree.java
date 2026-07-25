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
    public boolean isCousins(TreeNode root, int x, int y) {
        int dx=0,dy=0,level=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr=q.poll();
                if(curr.val==x)dx=level;
                if(curr.val==y)dy=level;
                if(curr.left!=null&&curr.right!=null){
                    if(curr.left.val==x&&curr.right.val==y||curr.left.val==y&&curr.right.val==x)return false;
                }
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }
            level++;
        }
        return dx==dy;
    }
}