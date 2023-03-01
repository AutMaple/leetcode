package removeElement_27;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int len = removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }
}

class Solution1 {
    public static int removeElement(int[] nums, int val) {
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            if (nums[head] == val) {
                nums[head] = nums[tail--];
            } else {
                head++;
            }
        }
        return head;
    }
}
