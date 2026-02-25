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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1,map);
    }public TreeNode build(int[]preorder,int start,int end,HashMap<Integer,Integer>map){
        if(start>end)return null;
        int rootval=preorder[idx++];
        TreeNode root=new TreeNode(rootval);
        int preidx=map.get(rootval);
        root.left=build(preorder,start,preidx-1,map);
        root.right=build(preorder,preidx+1,end,map);
        return root;
    }
}