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
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        build(root,null,map);
        q.offer(target);
        set.add(target);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(level==k)break;
            while(size-->0){
                TreeNode curr=q.remove();
                if(curr.left!=null&&!set.contains(curr.left)){
                    set.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right!=null&&!set.contains(curr.right)){
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
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;

    }public void build(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,parent);
        build(node.left,node,map);
        build(node.right,node,map);
    }
}