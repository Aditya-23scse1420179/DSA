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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        build(root,null,map);
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>set=new HashSet<>();
        set.add(target);
        q.offer(target);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(level==k)break;
            while(size-->0){
                TreeNode curr=q.remove();
                if(curr.left!=null&&!set.contains(curr.left)){
                    q.offer(curr.left);
                    set.add(curr.left);
                }if(curr.right!=null&&!set.contains(curr.right)){
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
        while(!q.isEmpty()){
            ans.add(q.remove().val);
        }
        return ans;
    }public void build(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,parent);
        build(node.left,node,map);
        build(node.right,node,map);
    }
}