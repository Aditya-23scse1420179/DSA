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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                int val=curr.val;
                if(val>max){
                    max=val;
                }
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }
            if(max!=-1){
                ans.add(max);
            }else ans.add(-1);
        }
        return ans;
    }
}