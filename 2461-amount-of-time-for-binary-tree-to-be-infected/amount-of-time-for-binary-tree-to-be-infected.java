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
    public TreeNode find(TreeNode root,int start){
        if(root==null)return null;
        if(root.val==start)return root;
        TreeNode ans=find(root.left,start);
        if(ans!=null)return ans;// ans hoga jisme store kar rahe 
        return find(root.right,start);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        build(root,null,map);
        Set<TreeNode>set=new HashSet<>();
        set.add(find(root,start));
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(find(root,start));
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr=q.remove();
                if(curr.left!=null&&!set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }
                if(curr.right!=null&&!set.contains(curr.right)){
                    q.offer(curr.right);
                    set.add(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null&&!set.contains(parent)){
                    q.offer(parent);
                    set.add(parent);
                }
            }
            level++;
        }
        return level-1;

    }public void build(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;//root nahi node se check hoga 
        map.put(node,parent);
        build(node.left,node,map);
        build(node.right,node,map);
    }
}