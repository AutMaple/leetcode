package backspaceCompare_844;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> sStack = reverse(s);
        Deque<Character> tStack = reverse(t);
        if (sStack.size() != tStack.size())
            return false;
        int len = sStack.size();
        for (int i = 0; i < len; i++) {
            char c1 = sStack.poll();
            char c2 = tStack.poll();
            if (c1 != c2)
                return false;
        }
        return true;
    }

    public static Deque<Character> reverse(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#')
                stack.push(s.charAt(i));
            else
                stack.poll();
        }
        return stack;
    }

    public static void main(String[] args) {
        String s = "a#c";
        String t = "c";
//        boolean b = backspaceCompare(s, t);
        boolean b = Solution1.backspaceCompare(s, t);
        System.out.println(b);
    }
}


class Solution1 {
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#')
                sb.append(c);
            else if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

class Solution2 {
    /**
     * 双指针解决问题，由于一个 # 只能够删除前面的字符，因此可以从后面开始遍历<br>
     * 1. 遇到一个 # 符说明就需要删除前面的非 # 字符, 计数器 skip 加 1<br>
     * 2. 如果遇到的是非 # 符，就需要看 skip 是否为 0，不为 0 则直接退出循环
     * 3. 跳出循环之后进行比较
     */
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            int skipS = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#')
                    skipS++;
                else if (skipS > 0)
                    skipS--;
                else
                    break;
                i--;
            }
            int skipT = 0;
            while (j >= 0) {
                if (t.charAt(j) == '#')
                    skipT++;
                else if (skipT > 0)
                    skipT--;
                else
                    break;
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i--) != t.charAt(j--))
                    return false;
            } else {
                return i < 0 && j < 0;
            }
        }
        return true;
    }
}
