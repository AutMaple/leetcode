package letterCombinations_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // digitIndex: 表示第几个数字
    // letterIndex: 数字所表示字母的位置
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return res;
        String[] lettersMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(0, lettersMap, digits);
        return res;
    }

    public void dfs(int digitIndex, String[] lettersMap, String digits) {
        if (digitIndex == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = lettersMap[digits.charAt(digitIndex) - 'a'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digitIndex + 1, lettersMap, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
