package reverseLeftWords_offer_58;

/**
 * 数组的翻转，翻转之后，可以变换元素的位置，并且先全局翻转，在局部进行翻转或者先局部翻转在全局进行翻转
 * 都可以做到逆转局部与局部之间的顺序, 例如：
 * Hello World AutMaple, 先全局逆转：elpaMtuA dlroW olleH, 再局部逆转: AutMaple World Hello
 * Hello World AutMaple, 先局部逆转：olleH dlroW elpaMtuA, 再全局逆转: AutMaple World Hello
 */
public class Solution {
    // 借助辅助空间的做法
    public static String reverseLeftWords(String s, int n) {
        String t = s + s;
        return t.substring(n, n + s.length());
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String res = Solution1.reverseLeftWords(s, 2);
        System.out.println(res);
    }
}

class Solution1 {
    // 原地修改法
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    public static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
