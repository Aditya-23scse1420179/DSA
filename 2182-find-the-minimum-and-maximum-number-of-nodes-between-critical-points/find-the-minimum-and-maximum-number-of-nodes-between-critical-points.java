/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        if(list.size()<3)return new int[]{-1,-1};
        int[]ans=new int[2];
        List<Integer>lt=new ArrayList<>();
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)>list.get(i-1)&&list.get(i)>list.get(i+1))lt.add(i);
            if(list.get(i)<list.get(i-1)&&list.get(i)<list.get(i+1))lt.add(i);
        }
        if(lt.size()<2)return new int[]{-1,-1};
        int min=(int)1e9;
        for(int i=1;i<lt.size();i++){
            min=Math.min(min,lt.get(i)-lt.get(i-1));
        }
        ans[0]=min;
        ans[1]=lt.get(lt.size()-1)-lt.get(0);
        return ans;

    }
}