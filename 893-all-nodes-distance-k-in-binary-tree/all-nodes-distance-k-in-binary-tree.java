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
        ArrayList<Integer>list=new ArrayList<>();
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        buildParentMap(root,null,map);
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>visit=new HashSet<>();
        int distance=0;
        visit.add(target);
        q.offer(target);
        //level order
        while(!q.isEmpty())
        {
            int size=q.size();
            if(distance==k)break;
            while(size-->0)
            {
                TreeNode curr=q.remove();
                if(curr.left!=null && !visit.contains(curr.left))
                {
                    q.offer(curr.left);
                    visit.add(curr.left);
                }
                if(curr.right!=null && !visit.contains(curr.right))
                {
                    q.offer(curr.right);
                    visit.add(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null && !visit.contains(parent))
                {
                    q.offer(parent);
                    visit.add(parent);
                }
            }
            distance++;
            
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }public void buildParentMap(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,parent);
        buildParentMap(node.left,node,map);
        buildParentMap(node.right,node,map);
    }
}