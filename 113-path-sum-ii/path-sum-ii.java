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

    public void helper(TreeNode root, int targetSum,List<Integer> subList,List<List<Integer>> result) {
        if (root == null) return;
        subList.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(subList));
        } else {
            helper(root.left, targetSum - root.val, subList, result);
            helper(root.right, targetSum - root.val, subList, result);
        }
        subList.remove(subList.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), result);
        return result;
    }
}