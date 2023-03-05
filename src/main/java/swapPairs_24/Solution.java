package swapPairs_24;

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
    // 递归后序遍历实现
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preNode = swapPairs(head.next.next);
        ListNode res = head.next;
        res.next = head;
        head.next = preNode;
        return res;
    }
}

class Solution1 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            ListNode firstNode = cur.next;
            ListNode secondNode = firstNode.next;
            ListNode thirdNode = secondNode.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = thirdNode;
            cur = firstNode;
        }
        return dummyNode.next;
    }
}
