package intersection_349;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] counter = new int[1001];
        for (int num : nums1) {
            counter[num]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums2) {
            if (counter[num] != 0)
                set.add(num);
        }
        return set.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}
