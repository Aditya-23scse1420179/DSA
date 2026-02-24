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
    if (root==null) return null;
    if (root.val== start) return root; 
    TreeNode Res =find(root.left, start);
    if(Res!=null)return Res;
    return find(root.right,start);
}
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode>map=new HashMap<>();
        buildParentMap(root,null,map);
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode>visit=new HashSet<>();
        int distance=0;
        visit.add(find(root,start));
        q.offer(find(root,start));
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode curr=q.remove();
                if(curr.left!=null && !visit.contains(curr.left)){
                    q.offer(curr.left);
                    visit.add(curr.left);
                }
                if(curr.right!=null && !visit.contains(curr.right)){
                    q.offer(curr.right);
                    visit.add(curr.right);
                }
                TreeNode parent=map.get(curr);
                if(parent!=null && !visit.contains(parent)){
                    q.offer(parent);
                    visit.add(parent);
                }
            }
            distance++;
            
        }
        return distance-1;
    }public void buildParentMap(TreeNode node,TreeNode parent,HashMap<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,parent);
        buildParentMap(node.left,node,map);
        buildParentMap(node.right,node,map);
    }
}