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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr =root;
        while (curr != null){
            stack.push(curr);
            curr= curr.left;
        }
        while (!stack.isEmpty()){
            curr= stack.pop();
            k--;
            if (k== 0){
                return curr.val;
            }
            TreeNode node = curr.right;
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
        }
        throw new IllegalArgumentException("k is larger than number of nodes");
    }
}
