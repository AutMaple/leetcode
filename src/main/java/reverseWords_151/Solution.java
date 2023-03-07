package reverseWords_151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> strs = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strs);
        return String.join(" ", strs);
    }

    public static void main(String[] args) {
        String s = "  Hello";
        String res = Solution1.reverseWords(s);
        System.out.println(res);
    }
}

class Solution1 {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = removeBlank(chars);
        reverse(chars, start, chars.length - 1);
        int low = start;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, low, i - 1);
                low = i + 1;
            }
        }
        reverse(chars, low, chars.length - 1);
        return new String(chars, start, chars.length - start);
    }

    public static int removeBlank(char[] chars) {
        int index = chars.length;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c != ' ' || index != chars.length) {
                if (c == ' ' && chars[index] != ' ')
                    chars[--index] = c;
                else if (c != ' ')
                    chars[--index] = c;
            }
        }
        while (chars[index] == ' ')
            index++;
        return index;
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
