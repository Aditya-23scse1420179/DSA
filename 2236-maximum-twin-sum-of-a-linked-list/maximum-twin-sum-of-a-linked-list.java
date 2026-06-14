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
    public int pairSum(ListNode head) {
        ArrayList<Integer>ans=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            ans.add(curr.val);
            curr=curr.next;
        }
        int n=ans.size();
        int i=0,j=n-1;
        int sum=0;
        while(i<j){
            sum=Math.max(sum,ans.get(i)+ans.get(j));
            i++;
            j--;
        }
        return sum;
    }
}