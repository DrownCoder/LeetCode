/**
 * Author : xuan.
 * Date : 2019-03-04.
 * Description :the description of this file
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
}
