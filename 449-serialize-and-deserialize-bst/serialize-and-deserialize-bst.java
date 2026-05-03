/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return "";
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("-1 ");
                continue;
            }
            sb.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.length()==0)return null;
        Queue<TreeNode>q=new LinkedList<>();
        String[]s=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(s[0]));
        q.offer(root);
        for(int i=1;i<s.length;i++){
            TreeNode parent=q.poll();
            if(!s[i].equals("-1")){
                TreeNode left=new TreeNode(Integer.parseInt(s[i]));
                parent.left=left;
                q.offer(left);
            }
            if(!s[++i].equals("-1")){
                TreeNode right=new TreeNode(Integer.parseInt(s[i]));
                parent.right=right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;