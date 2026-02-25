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
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx=postorder.length-1;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,inorder.length-1,map);
    }public TreeNode build(int[]postorder,int start,int end,HashMap<Integer,Integer>map){
        if(start>end)return null;
        int root=postorder[idx--];
        TreeNode node=new TreeNode(root);
        int post=map.get(root);
        node.right=build(postorder,post+1,end,map);
        node.left=build(postorder,start,post-1,map);
        return node;
    }
}