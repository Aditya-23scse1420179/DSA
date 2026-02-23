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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>level=new ArrayList<>();
        if(root==null)return level;
        Queue<TreeNode>q=new LinkedList<>();
        boolean flag=true;
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer>ans=new ArrayList<>();
            int size=q.size();
            while(size-->0){
                TreeNode node=q.remove();
                ans.add(node.val);
                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            if(!flag)Collections.reverse(ans);
            level.add(ans);
            flag=!flag; 
        }
        return level;
    }
}