package must;

/**
 * Author : xuan.
 * Date : 2019-03-13.
 * Description :交换数字
 */
class exchangeNum {
    public static void exchangeNum(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }
}
