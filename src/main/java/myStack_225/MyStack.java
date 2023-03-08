package myStack_225;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    private Deque<Integer> from = new ArrayDeque<>();
    private Deque<Integer> to = new ArrayDeque<>();


    public MyStack() {

    }

    public void push(int x) {
        from.addLast(x);
        while (!to.isEmpty()) {
            from.addLast(to.removeFirst());
        }
        Deque<Integer> tmp = from;
        from = to;
        to = tmp;
    }

    public int pop() {
        return to.removeFirst();
    }


    public int top() {
        return to.getFirst();
    }

    public boolean empty() {
        return to.isEmpty();
    }
}
