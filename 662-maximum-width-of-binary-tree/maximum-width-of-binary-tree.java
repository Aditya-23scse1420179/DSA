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
    static class pair
    {
        TreeNode node;
        int idx;
        public pair(TreeNode node,int idx)
        {
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max=0;
        Deque<pair>q=new ArrayDeque<>();//doubly ended queue
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int first=q.peekFirst().idx;
            int last=q.peekLast().idx;
            max=Math.max(max,last-first+1);
            while(size-->0)
            {
                pair curr=q.poll();
                TreeNode node=curr.node;
                int id=curr.idx;
                if(node.left!=null)q.offer(new pair(node.left,2*id+1));
                if(node.right!=null)q.offer(new pair(node.right,2*id+2));
            }
        }
        return max;
    }
}