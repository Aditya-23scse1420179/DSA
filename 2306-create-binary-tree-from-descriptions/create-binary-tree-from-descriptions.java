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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode>map=new HashMap<>();
        HashSet<Integer>set=new HashSet<>();
        for(int[]d:descriptions){
            int p=d[0];
            int n=d[1];
            int t=d[2];
            map.putIfAbsent(p,new TreeNode(p));
            map.putIfAbsent(n,new TreeNode(n));
            TreeNode parent=map.get(p);
            TreeNode child=map.get(n);
            if(t==1){
                parent.left=child;
            }else{
                parent.right=child;
                
            }
            set.add(child.val);
        }
        for(int a:map.keySet()){
            if(!set.contains(a))return map.get(a);
        }
        return null;
    }
}