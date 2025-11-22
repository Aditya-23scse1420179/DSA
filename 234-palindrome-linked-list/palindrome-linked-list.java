class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = reverselist(slow);
        ListNode fasthalf = head;
        ListNode checkhalf = secondhalf;
        while (checkhalf != null) {
            if (fasthalf.val != checkhalf.val) return false;
            fasthalf = fasthalf.next;
            checkhalf = checkhalf.next;
        }
        return true;
    }
    public ListNode reverselist(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nexttemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexttemp;
        }
        return prev;
    }
}
