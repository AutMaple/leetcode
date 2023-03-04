package removeElements_203;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }
}
