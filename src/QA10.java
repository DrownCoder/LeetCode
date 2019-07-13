/**
 * Author : xuan.
 * Date : 2019-04-01.
 * Description :344 反转字符串
 */
class QA10 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int start = 0;
        int end = s.length - 1;
        char temp;
        while (start <= end) {
            temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    public void reverseString2(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int start = 0;
        int end = s.length - 1;
        char temp;
        while (start <= end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
