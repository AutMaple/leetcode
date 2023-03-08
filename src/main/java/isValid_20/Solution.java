package isValid_20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '[') stack.addLast(']');
            else if (c == '(') stack.addLast(')');
            else if (c == '{') stack.addLast('}');
            else if (stack.isEmpty() || stack.removeLast() != c) // 处理右括号多的情况
                return false;
        }
        return stack.isEmpty();
    }
}
