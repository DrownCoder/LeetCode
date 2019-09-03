import java.util.ArrayList;
import java.util.List;

/**
 * Author : xuan.
 * Date : 2019-03-08.
 * Description :131.给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 */
class QA7 {
    private static List<List<String>> res = new ArrayList<>();
    private static String ss;

    public static void main(String[] args) {
        partition("aab");

    }

    /**
     * 基本的回溯法，有点像动态规划，先求前面的回文字符串，然后加上剩余子字符串的回文字符串。
     */
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        ss = s;
        dfs(new ArrayList<>(), 0);
        return res;
    }

    public static void dfs(List<String> ll, int index) {
        if (index == ss.length()) {
            res.add(new ArrayList<>(ll));
            return;
        }
        for (int i = index; i < ss.length(); i++) {
            if (isPalindrome(index, i)) {
                //如果当前是回文串
                ll.add(ss.substring(index, i + 1));
                //判断后面的回文串
                dfs(ll, i + 1);
                //回溯一个
                ll.remove(ll.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (ss.charAt(start) != ss.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
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
