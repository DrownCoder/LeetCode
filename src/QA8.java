import java.util.ArrayList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-03-08.
 * Description :给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 */
class QA8 {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        List<List<String>> results = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            List<String> result = new ArrayList<>();
            for (int t = 0; t < chars.length; t += i) {
                for (int m = 0; m <= i; m++) {
                    str.append(chars[t + m]);
                }
                if (isPalindrome(str.toString())) {
                    result.add(str.toString());
                }
            }
            if (result.size() != 0) {
                results.add(result);
            }
        }
        return results;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0 || s.trim().length() == 1) {
            return true;
        }
        char[] source = s.toCharArray();
        int start = 0;
        int end = source.length - 1;
        while (start <= end) {
            start = getStartChar(source, start);
            end = getEndChar(source, end);
            if (start >= end) {
                return true;
            }
            if (!String.valueOf(source[start]).toLowerCase().equals(String.valueOf(source[end]).toLowerCase())) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static int getEndChar(char[] source, int end) {
        int i;
        for (i = end; i > 0; i--) {
            if (Character.isLetterOrDigit(source[i])) {
                return i;
            }
        }
        return i;
    }

    private static int getStartChar(char[] source, int start) {
        int i;
        for (i = start; i < source.length; i++) {
            if (Character.isLetterOrDigit(source[i])) {
                return i;
            }
        }
        return i;
    }


}
