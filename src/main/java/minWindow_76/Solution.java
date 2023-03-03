package minWindow_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // s = "ADOBECODEBANC", t = "ABC"
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> curMap = new HashMap<>();
        int resL = 0, resR = s.length(), l = 0, r = 0;
        int sLen = s.length();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int count = targetMap.keySet().size();
        boolean isChanged = false;
        while (r < sLen) {
            char c = s.charAt(r++);
            if (!targetMap.containsKey(c))
                continue;
            curMap.put(c, curMap.getOrDefault(c, 0) + 1);
            if (curMap.get(c).equals(targetMap.get(c)))
                count--;
            // 缩小窗口大小
            while (count == 0 && l < sLen) {
                char c1 = s.charAt(l);
                if (!targetMap.containsKey(c1)) {
                    l++;
                } else if (curMap.get(c1) > targetMap.get(c1)) {
                    l++;
                    curMap.put(c1, curMap.get(c1) - 1);
                } else {
                    if ((resR - resL) >= (r - l)) {
                        isChanged = true;
                        resR = r;
                        resL = l;
                    }
                    count++;
                    curMap.put(c1, curMap.get(c1) - 1);
                    l++;
                }
            }
        }
        return isChanged ? s.substring(resL, resR) : "";
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "abaaa", t = "b";
//        String s = "bba", t = "ab";
        String s = "b", t = "b";
//        String s = "bbabbbc", t = "bb";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}