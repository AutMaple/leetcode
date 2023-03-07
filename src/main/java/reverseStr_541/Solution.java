package reverseStr_541;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int low = 0, cur = 0;
        while (cur < chars.length) {
            cur += 2 * k;
            if (cur > chars.length) {
                if (low + k > chars.length) {
                    reverse(chars, low, chars.length - 1);
                } else {
                    reverse(chars, low, low + k - 1);
                }
            } else {
                reverse(chars, low, low + k - 1);
                low += 2 * k;
            }
        }
        return new String(chars);
    }

    public void reverse(char[] s, int low, int high) {
        while (low < high) {
            char c = s[low];
            s[low] = s[high];
            s[high] = c;
            low++;
            high--;
        }
    }
}


class Solution1 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, chars.length) - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] s, int low, int high) {
        while (low < high) {
            char c = s[low];
            s[low] = s[high];
            s[high] = c;
            low++;
            high--;
        }
    }
}
