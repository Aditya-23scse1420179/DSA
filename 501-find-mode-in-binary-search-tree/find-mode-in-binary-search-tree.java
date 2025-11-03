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
    private TreeNode prev = null;    
    private int currCount = 0;       
    private int maxCount = 0;       
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result =new int[modes.size()];
        for (int i =0;i< modes.size();i++) {
            result[i] =modes.get(i);
        }
        return result;
    }
    private void inorder(TreeNode node) {
        if (node ==null) return;
        inorder(node.left);
        if (prev!= null && prev.val ==node.val) {
            currCount++;
        }else{
            currCount =1;
        }if (currCount >maxCount){
            maxCount =currCount;
            modes.clear();
            modes.add(node.val);
        }else if(currCount ==maxCount){
            modes.add(node.val);
        }
        prev = node;
        inorder(node.right);
    }
}