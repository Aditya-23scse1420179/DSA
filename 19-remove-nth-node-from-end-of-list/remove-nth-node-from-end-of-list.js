/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let dummy=new ListNode(0,head);
    let curr=dummy;
    let second=dummy;
    for(let i=0;i<n+1;i++){
        curr=curr.next;
    }
    while(curr!=null){
        curr=curr.next;
        second=second.next;
    }
    second.next=second.next.next;
    return dummy.next;
};