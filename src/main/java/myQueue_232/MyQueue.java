package myQueue_232;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private final Deque<Integer> from = new ArrayDeque<>();
    private final Deque<Integer> to = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        from.addLast(x);
    }

    public int pop() {
        if (to.isEmpty()) {
            move();
        }
        return to.removeLast();
    }

    public int peek() {
        if (to.isEmpty()) {
            move();
        }
        return to.getLast();
    }

    public boolean empty() {
        return from.isEmpty() && to.isEmpty();
    }

    private void move() {
        while (!from.isEmpty()) {
            to.add(from.removeLast());
        }
    }
}
