package repeatedSubstringPattern_459;

public class Solution {
    // 时间复杂度为 O(n**2)
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            int j = 0;
            String template = s.substring(0, i);
            while (j < s.length() && s.startsWith(template, j))
                j += i;
            if (j == s.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = Solution1.repeatedSubstringPattern("abab");
//        boolean res = Solution1.repeatedSubstringPattern("aba");
//        boolean res = Solution1.repeatedSubstringPattern("abac");
        System.out.println(res);
    }
}

class Solution1 {
    // 效率低下，超时
    public static boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            String reverse = reverse(s, i);
            if (s.equals(reverse))
                return true;
        }
        return false;
    }

    public static String reverse(String s, int len) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, len - 1);
        reverse(chars, len, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
    }
}

class Solution3 {
    // KMP 算法实现
    // 如果字符串 s 是由重复子串构成的，那么 next[s.length() -1] = len(最小重复子串)
    // 可以通过将 next 数组打印出来进行辅助理解
    public static boolean repeatedSubstringPattern(String s) {
        int[] next = getNext(s);
        int len = s.length();
        return next[len - 1] != -1 && len % (len - next[len - 1] + 1) == 0;
    }

    public static int[] getNext(String s) {
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < len; i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1))
                j = next[j];
            if (s.charAt(i) == s.charAt(j + 1))
                j++;
            next[i] = j;
        }
        return next;
    }
}
