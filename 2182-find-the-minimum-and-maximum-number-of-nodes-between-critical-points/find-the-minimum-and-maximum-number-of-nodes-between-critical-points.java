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
        if(head==null||head.next==null||head.next.next==null)return new int[]{-1,-1};
        ListNode curr=head.next,nexxt=head.next.next,prev=head;
        int id=0;
        List<Integer>lt=new ArrayList<>();
        while(curr.next!=null&&nexxt!=null){
            if(curr.val>nexxt.val&&curr.val>prev.val)lt.add(id);
            if(curr.val<nexxt.val&&curr.val<prev.val)lt.add(id);
            prev=curr;
            curr=curr.next;
            nexxt=nexxt.next;
            id++;
        }
        if(lt.size()<2)return new int[]{-1,-1};
        int[]ans=new int[2];
        int min=(int)1e9;
        for(int i=1;i<lt.size();i++){
            min=Math.min(min,lt.get(i)-lt.get(i-1));
        }
        ans[0]=min;
        ans[1]=lt.get(lt.size()-1)-lt.get(0);
        return ans;

    }
}