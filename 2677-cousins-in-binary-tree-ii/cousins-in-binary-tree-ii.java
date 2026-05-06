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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> levelSum = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            levelSum.add(sum);
        }
        // root has no cousins
        root.val = 0;
        q.offer(root);
        int level = 0;
        // pass 2
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                int siblingSum = 0;
                if (curr.left != null)
                    siblingSum += curr.left.val;
                if (curr.right != null)
                    siblingSum += curr.right.val;
                if (curr.left != null) {
                    curr.left.val = levelSum.get(level + 1) - siblingSum;
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = levelSum.get(level + 1) - siblingSum;
                    q.offer(curr.right);
                }
            }
            level++;
        }
        return root;
    }
}