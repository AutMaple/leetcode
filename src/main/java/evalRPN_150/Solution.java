package evalRPN_150;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // 在进行运算的时候，需要注意运算数的顺序问题。先出栈的是第二个操作数，后出栈的是第一个操作数
    // 这点必须注意，否则在进行减法和除法的时候，操作数的顺序不同，结果也会不同，但加法和乘法不用担心这个问题
    public static int evalRPN(String[] tokens) {
        Deque<Integer> operands = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int a = operands.removeFirst();
                int b = operands.removeFirst();
                switch (token) {
                    case "+":
                        operands.addFirst(b + a);
                        break;
                    case "-":
                        operands.addFirst(b - a);
                        break;
                    case "*":
                        operands.addFirst(b * a);
                        break;
                    default:
                        operands.addFirst(b / a);
                        break;
                }
            } else {
                operands.addFirst(Integer.parseInt(token));
            }
        }
        return operands.removeFirst();
    }
}

class Solution1 {
    public static int evalRPN(String[] tokens) {
        int[] operands = new int[(tokens.length + 1) / 2];
        int top = -1;
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int a = operands[top--];
                int b = operands[top--];
                switch (token) {
                    case "+":
                        operands[++top] = b + a;
                        break;
                    case "-":
                        operands[++top] = b - a;
                        break;
                    case "*":
                        operands[++top] = b * a;
                        break;
                    default:
                        operands[++top] = b / a;
                        break;
                }
            } else {
                operands[++top] = Integer.parseInt(token);
            }
        }
        return operands[0];
    }
}
