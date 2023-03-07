package findAnagram_438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Solution {
    // cbaebabacd
    // abc
    // 0, 6
    public static List<Integer> findAnagram(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] target = new int[26];
        int[] cur = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            cur[c - 'a']++;
        }
        if (Arrays.equals(cur, target))
            res.add(0);
        for (int i = 0; i < s.length() - p.length(); i++) {
            char ol = s.charAt(i);
            char h = s.charAt(i + p.length());
            cur[ol - 'a']--;
            cur[h - 'a']++;
            if (Arrays.equals(cur, target))
                res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abca", p = "abc";
//        String s = "cbaebabacd", p = "abc";
//        String s = "aa", p = "bb";
        List<Integer> res = Solution1.findAnagram(s, p);
        System.out.println(res);
    }
}

class Solution1 {
    public static List<Integer> findAnagram(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']--;
        }
        char[] chars = s.toCharArray();
        for (int l = 0, r = 0; r < chars.length; r++) {
            target[chars[r] - 'a']++;
            if (r >= p.length()) target[chars[l++] - 'a']--;
            long count = Arrays.stream(target)
                    .filter(num -> num != 0)
                    .count();
            if (count == 0)
                res.add(l);
        }
        return res;
    }
}
