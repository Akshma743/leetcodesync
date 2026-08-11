class Solution {
    public ListNode swapPairs(ListNode head) {

        // 0 ya 1 node hai to swap possible nahi
        if (head == null || head.next == null) {
            return head;
        }

        // First node ko second node ke saath swap
        ListNode second = head.next;

        head.next = swapPairs(second.next);
        second.next = head;

        return second;
    }
}