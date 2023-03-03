package totalFruit_904;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int totalFruit(int[] fruits) {
        int[] selectedTypes = {-1, -1};
        int res = 0, low = 0, high = 0;
        boolean isChanged = false;
        // 给 type 赋两个不同的初值
        while (high < fruits.length && (selectedTypes[0] == -1 || selectedTypes[1] == -1)) {
            if (selectedTypes[0] == fruits[high])
                high++;
            else if (selectedTypes[0] == -1)
                selectedTypes[0] = fruits[high++];
            else
                selectedTypes[1] = fruits[high++];
        }
        while (high < fruits.length) {
            int curFruit = fruits[high];
            if (selectedTypes[0] != curFruit && selectedTypes[1] != curFruit) {
                isChanged = true;
                res = Math.max(res, high - low);
                int p = high - 1;
                int type = fruits[p];
                while (p > 0) {
                    if (fruits[p] != type)
                        break;
                    p--;
                }
                low = p + 1;
                selectedTypes[0] = fruits[low];
                selectedTypes[1] = curFruit;
            }
            high++;
        }
        return isChanged ? Math.max(res, high - low) : fruits.length;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 1, 3, 3, 3, 4, 4, 4, 4, 0, 4};
        int res = Solution2.totalFruit(fruits);
        System.out.println(res);
    }
}

class Solution1 {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);
                left++;
            }
            res = Math.max(res, i - left);
        }
        return res;
    }
}

class Solution2 {
    // 简单，高效
    public static int totalFruit(int[] fruits) {
        int typeA = fruits[0];
        int typeB = -1;
        int left = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < fruits.length; i++) {
            int cur = fruits[i];
            if (cur != typeA) {
                if (cur != typeB && typeB != -1) {
                    result = Math.max(result, i - left);
                    left = right;
                }
                // 每次保证 typeA 是当前最新的类型
                typeB = typeA;
                typeA = cur;
                // 每次 curType 和 当前的 type 不一样时，需要更新最又的指针
                right = i;
            }
        }
        return Math.max(result, fruits.length - left);
    }
}
