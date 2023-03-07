package intersection_250;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for (int num : nums1) {
            map1[num]++;
        }
        for (int num : nums2) {
            map2[num]++;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < map1.length; i++) {
            if (map1[i] != 0 && map2[i] != 0) {
                int duplicate = Math.min(map1[i], map2[i]);
                for (int j = 0; j < duplicate; j++) {
                    numsList.add(i);
                }
            }
        }
        return numsList.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}
