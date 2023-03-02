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
        int[] fruits = {1, 1, 4, 0, 4};
        int res = totalFruit(fruits);
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
