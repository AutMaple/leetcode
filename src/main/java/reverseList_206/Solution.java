package reverseList_206;

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
    // 双指针实现
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

class Solution1 {
    // 头插法实现
    public static ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummyNode.next;
            dummyNode.next = head;
            head = tmp;
        }
        return dummyNode.next;
    }
}

class Solution2 {
    // 后序遍历实现
    static ListNode newHead;

    public static ListNode reverseList(ListNode head) {
        recursive(head);
        return newHead;
    }

    public static ListNode recursive(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return head;
        }
        ListNode pre = reverseList(head.next);
        pre.next = head;
        head.next = null;
        return head;
    }
}

class Solution3 {
    // 前序遍历
    public static ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null)
            return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }
}

class Solution4 {
    // 后序遍历优化版
    // 之所以代码会变的简洁，得益于翻转之后头结点的返回方式
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tailNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tailNode;
    }
}

