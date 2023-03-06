package isAnagram_242;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    // hashMap 实现
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (mapS.keySet().size() != mapT.keySet().size())
            return false;
        for (char c : mapS.keySet()) {
            if (!mapT.containsKey(c) || !Objects.equals(mapT.get(c), mapS.get(c)))
                return false;
        }
        return true;
    }
}

class Solution1 {
    // 将 String 转换成 char[] 数组进行遍历，效率更高
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] mapS = new int[26];
        for (char c : s.toCharArray()) {
            mapS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            mapS[c - 'a']--;
            if (mapS[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
