package removeDuplicates_1047;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 栈解决
    public static String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                Character preChar = stack.getLast();
                if (preChar == c)
                    stack.removeLast();
                else
                    stack.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = Solution1.removeDuplicates("aaabbcc");
        System.out.println(res);
    }
}

class Solution1 {
    public static String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int top = -1; // 始终指向栈顶待比较的字符
        for (int i = 0; i < chars.length; i++) {
            // != 的比较速度优于 >=, <=
            if (top != -1 && chars[i] == chars[top])
                top--;
            else
                chars[++top] = chars[i];
        }
        return new String(chars, 0, top + 1);
    }
}
