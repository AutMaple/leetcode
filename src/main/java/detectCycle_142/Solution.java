package detectCycle_142;

import java.util.HashSet;
import java.util.Set;

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

    /**
     * 快慢指针解法
     * <p>
     * fast 与 slow 的速度差为 1 <br>
     * 如果 fast 与 slow 的距离为 b, 则 fast 和 slow 指针同时移动 b 次就会相遇<br>
     * 这就意味着 slow 到达环起点后, fast 和 slow 最多走一圈就会相遇(fast 和 slow 指向同一个节点时) <br>
     * 设置变量 a, b, c<br>
     * a 为链表头结点到环入口点的距离<br>
     * b 为 fast 和 slow 相遇时距离环入口点的距离<br>
     * c 满足 b + c = 环的长度<br>
     * 两个指针相遇时 fast 走过的距离为：a + n(b+c) + b = a + (n + 1)b + nc<br>
     * a + (n + 1)b + nc = 2(a+b) => a =  (n-1)(b+c) + c <br>
     * 从而当 fast 和 slow 相遇后，只需要将一个指针从链表开始遍历，直到和 slow 指针相等即可
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}

class Solution1 {
    // Set 实现
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null) {
            if (visited.contains(head))
                return head;
            visited.add(head);
            head = head.next;
        }
        return null;
    }
}
