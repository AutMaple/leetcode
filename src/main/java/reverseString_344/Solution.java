package reverseString_344;

import java.util.Arrays;

public class Solution {
    public static void reverseString(char[] s) {
        int low = 0, high = s.length - 1;
        while (low < high) {
            char tmp = s[low];
            s[low] = s[high];
            s[high] = tmp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
