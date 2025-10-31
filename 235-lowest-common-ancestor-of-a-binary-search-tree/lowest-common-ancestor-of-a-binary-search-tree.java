/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode current = root;
        while (current!= null) {
            int curVal= current.val;
            if(curVal >pVal&&curVal >qVal){
                current = current.left;
            }else if(curVal <pVal &&curVal <qVal){
                current = current.right;
            }else{
                return current;
            }
        }
        return null;
    }
}