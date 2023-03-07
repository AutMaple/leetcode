package fourSumCount_454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> target = new HashMap<>();
        for (int n : nums1) {
            for (int v : nums2) {
                int a = n + v;
                target.put(a, target.getOrDefault(a, 0) + 1);
            }
        }
        for (int n : nums3) {
            for (int v : nums4) {
                int a = n + v;
                if (target.containsKey(-a)) {
                    ans += target.get(-a);
                }
            }
        }
        return ans;
    }
}
