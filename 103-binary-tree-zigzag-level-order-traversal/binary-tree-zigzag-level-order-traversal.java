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
        List<List<Integer>> ans = new ArrayList<>();
        if (root ==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true; 
        while (!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>(); 
            for (int i =0;i<size; i++){
                TreeNode p =q.remove();
                if (leftToRight){
                    level.addLast(p.val);  
                } else{
                    level.addFirst(p.val); 
                }
                if (p.left!=null){
                    q.offer(p.left);
                }    
                if (p.right!=null){ 
                    q.offer(p.right);
                }
            }
            ans.add(level);      
            leftToRight =!leftToRight; 
        }
        return ans;
    }
}