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
    public TreeNode find(TreeNode root, int start) {
        if(root==null)return null;
        if(root.val==start)return root;
        TreeNode ans=find(root.left,start);
        if(ans!=null)return ans;
        return find(root.right,start);

    }public int amountOfTime(TreeNode root, int start){
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>set=new HashSet<>();
        build(root,null,map);
        set.add(find(root,start));
        q.offer(find(root,start));
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr=q.poll();
                if(curr.left!=null&&!set.contains(curr.left)){
                    set.add(curr.left);
                    q.offer(curr.left);
                }if(curr.right!=null&&!set.contains(curr.right)){
                    set.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null&&!set.contains(parent)){
                    set.add(parent);
                    q.offer(parent);
                }
            }
            level++;
        }
        return level-1;
    }public void build(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,parent);
        build(node.left,node,map);
        build(node.right,node,map);
    }
}