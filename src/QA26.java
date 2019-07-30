/**
 * Author : xuan.
 * Date : 2019-06-27.
 * Description :替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 */
class QA26 {
    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';
        System.out.println(replaceBlank(string, 12));
    }

    public static char[] replaceBlank(char[] string, int usedLength) {
        if (string == null || string.length == 0) {
            return string;
        }
        int emptyLength = 0;
        for (char c : string) {
            if (c == ' ') {
                emptyLength++;
            }
        }
        int targetLength = emptyLength * 2 + usedLength;
        if (targetLength > string.length) {
            throw new IllegalStateException();
        }
        usedLength--;
        targetLength--;
        while (usedLength >= 0 && usedLength < targetLength) {
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return string;
    }

    public static char[] replaceBlank2(char[] string, int usedLength) {
        if (string == null || string.length == 0) {
            return string;
        }
        int emptyLength = 0;
        for (char c : string) {
            if (c == ' ') {
                emptyLength++;
            }
        }
        int targetLength = emptyLength * 2 + usedLength;
        if (targetLength > string.length) {
            throw new IllegalStateException();
        }
        usedLength--;
        targetLength--;
        while (usedLength > 0 && targetLength > 0) {
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return string;
    }

}
