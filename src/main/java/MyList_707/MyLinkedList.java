package MyList_707;

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

public class MyLinkedList {
    // 对 tail 指针的维护是关键，很多的细节
    ListNode head;

    int len = 0;

    public MyLinkedList() {
        head = new ListNode();
    }

    public int get(int index) {
        if (index >= len || index < 0)
            return -1;
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(len, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > len)
            return;
        if (index < 0) {
            index = 0;
        }
        len++;
        ListNode p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = p.next;
        p.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index >= len || index < 0)
            return;
        len--;
        if (index == 0) {
            head.next = null;
            return;
        }
        ListNode p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    private boolean check(int index) {
        return index < len;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        printList(list);
        list.addAtHead(2);
        printList(list);
        list.addAtHead(1);
        printList(list);
        list.addAtIndex(3, 0);
        printList(list);
        list.deleteAtIndex(3);
        printList(list);
        list.deleteAtIndex(2);
        printList(list);
        list.addAtHead(6);
        printList(list);
        list.addAtTail(4);
        printList(list);
        list.get(4);
        list.addAtHead(4);
        printList(list);
        list.addAtIndex(5, 0);
        printList(list);
        list.addAtHead(6);
        printList(list);
    }

    static void printList(MyLinkedList list) {
        for (ListNode p = list.head.next; p != null; p = p.next) {
            System.out.print(p.val + ",");
        }
        System.out.println();
    }
}
