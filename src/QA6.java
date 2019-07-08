/**
 * Author : xuan.
 * Date : 2019-03-04.
 * Description :125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
class QA6 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
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

    private static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] source = s.toCharArray();
        int start = 0;
        int end = source.length - 1;
        while (start < end) {
            start = filterInvalidCharStart(source, start);
            end = filterInvalidCharEnd(source, end);
            if (start >= end) {
                return false;
            }
            if (!String.valueOf(source[start]).toLowerCase().equals(String.valueOf(source[end]).toLowerCase())) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 过滤非有效的字符，例如空格，换行符
     */
    private static int filterInvalidCharStart(char[] source, int start) {
        for (; start < source.length; start++) {
            if (Character.isLetterOrDigit(source[start])) {
                return start;
            }
        }
        return start;
    }

    private static int filterInvalidCharEnd(char[] source, int end) {
        for (; end > 0; end--) {
            if (Character.isLetterOrDigit(source[end])) {
                return end;
            }
        }
        return end;
    }
}
