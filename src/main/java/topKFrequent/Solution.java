package topKFrequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> counterList = map.entrySet().stream()
                .map(entry -> new int[]{entry.getKey(), entry.getValue()})
                .collect(Collectors.toList());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        counterList.forEach(queue::offer);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }
}
