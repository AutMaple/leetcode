package findAnagram_438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // cbaebabacd
    // abc
    // 0, 6
    public static List<Integer> findAnagram(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int low = 0, high = 0, types = 0;
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        for (int count : target) {
            if (count != 0)
                types++;
        }
        while(high < s.length()) {
            high++;
            char c = s.charAt(high);
            if(--target[c - 'a'] < 0)
        }
        return res;
    }
}
