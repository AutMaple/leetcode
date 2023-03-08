package KMP;

import java.util.Arrays;

public class Solution {
    public static int search(String txt, String pattern) {
        if (pattern.length() == 0)
            return 0;
        int[] next = initNext(pattern);
        int j = -1;
        for (int i = 0; i < txt.length(); i++) {
            while (j >= 0 && txt.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (txt.charAt(i) == pattern.charAt(j + 1))
                j++;
            if (j == pattern.length() - 1)
                return i - pattern.length() + 1;
        }
        return -1;
    }

    /**
     * a  c  a  b a c a c
     * -1 -1  0 -1 0 1 2 1
     * a  b  a
     * -1 -1  0
     * <p>
     * 构建 next 数组的过程，其实也是一个字符串匹配的问题
     * 对于 acabacac 这个模式字符串来说，某个字符的最大相同前后缀需要通过其前一个字符的来进行判定
     */
    public static int[] initNext(String pattern) {
        // -1 版本的 next 数组
        int len = pattern.length();
        int[] next = new int[len];
        // 指向需要匹配的前一个字符, j 既是最大相同前后缀的长度 - 1，也代表模式串中下一个待匹配字符的前一个字符的指针
        int j = -1;
        next[0] = -1;
        for (int i = 1; i < len; i++) {
            while (j >= 0 && pattern.charAt(j + 1) != pattern.charAt(i))
                j = next[j];
            if (pattern.charAt(i) == pattern.charAt(j + 1))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static int[] next(String s) {
        int len = s.length();
        int[] next = new int[len];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = next[j - 1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        int index = search("acabacac", "abac");
        System.out.println(index);
        int[] next = initNext("abacabab");
        int[] abacababs = next("abacabab");
        System.out.println(Arrays.toString(next));
        System.out.println(Arrays.toString(abacababs));
    }
}
