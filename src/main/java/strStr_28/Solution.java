package strStr_28;

public class Solution {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int[] next = initNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1))
                j++;
            if (j == needle.length() - 1)
                return i - needle.length() + 1;
        }
        return -1;
    }

    public static int[] initNext(String pattern) {
        int len = pattern.length();
        if (len == 0)
            return null;
        int[] next = new int[len];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < len; i++) {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1))
                j = next[j];
            if (pattern.charAt(i) == pattern.charAt(j + 1))
                j++;
            next[i] = j;
        }
        return next;
    }
}
