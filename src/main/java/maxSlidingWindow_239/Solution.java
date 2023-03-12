package maxSlidingWindow_239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    // [1,3,-1,-3,5,3,6,7]
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 存放下标
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()]) {
                stack.removeLast();
            }
            stack.addLast(i);
        }
        res[0] = nums[stack.getFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()])
                stack.removeLast();
            stack.addLast(i);
            while (stack.getFirst() <= i - k)
                stack.removeFirst();
            res[i - k + 1] = nums[stack.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1};
        int[] res = maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(res));
    }
}

class Solution1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = k - 1;
        int maxIdx = -1, max = Integer.MIN_VALUE;
        int[] result = new int[n - k + 1];
        while(right < n){
            if(left <= maxIdx){
                if(nums[right] >= max){
                    maxIdx = right;
                    max = nums[right];
                }
            }else if(nums[right] >= max - 1){
                maxIdx = right;
                max = nums[right];
            }else if(nums[left] >= max - 1){
                maxIdx = left;
                max = nums[left];
            }else{
                max = Integer.MIN_VALUE;
                for(int i = left; i <= right; i++){
                    if(nums[i] >= max) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }
            }
            result[left] = max;
            left++;
            right++;
        }
        return result;
    }
}
