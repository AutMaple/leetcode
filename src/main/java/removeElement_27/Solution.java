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
        int len = Solution2.removeElement(nums, 2);
//        int len = removeElement(nums, 2);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }
}

class Solution1 {
    // 相向双指针确保了移动的元素是最少的，遍历一次数组即可
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

class Solution2 {
    // 双向指针分别找到第一个不符合要求的元素，在进行交换。保证了比较和交换的次数是最少的
    public static int removeElement(int[] nums, int val) {
        int head = 0, tail = nums.length - 1;
        while (head <= tail) {
            while (head <= tail && nums[head] != val)
                head++;
            while (head <= tail && nums[tail] == val)
                tail--;
            if (head < tail)
                nums[head++] = nums[tail--];
        }
        return head;
    }
}
