package groupAnagrams_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counter = new int[26];
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j : counter) {
                sb.append('a' + j);
                sb.append(j);
            }
            String val = sb.toString();
            List<String> list = map.computeIfAbsent(val, (key) -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
