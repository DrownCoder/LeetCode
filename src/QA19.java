import java.util.Random;

/**
 * Author : xuan.
 * Date : 2019-05-28.
 * Description :随机洗牌算法，空间复杂度O(1)
 * <p>
 * https://blog.csdn.net/qq_26399665/article/details/79831490
 * <p>
 * 在原始数组上对数字进行交互，省去了额外O(n)的空间。该算法的基本思想和 Fisher 类似，
 * 每次从未处理的数据中随机取出一个数字，然后把该数字放在数组的尾部，即数组尾部存放的是已经处理过的数字。
 * 由于是从后往前扫描，无法处理不知道长度或动态增长的数组。
 */
class QA19 {
    public static void Shuffle(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        for (int i = num.length - 1; i >= 1; i--) {
            swap(num, i, (new Random().nextInt() % (i + 1)));
        }
    }

    public static void swap(int[] num, int start, int end) {
        num[start] = num[start] + num[end];
        num[end] = num[start] - num[end];
        num[start] = num[start] - num[end];
    }


    public static void Shuffle2(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        for (int i = num.length - 1; i >= 0; i--) {
            swap2(num, i, new Random().nextInt() % (i + 1));
        }
    }

    public static void swap2(int[] num, int start, int end) {
        num[start] = num[start] + num[end];
        num[end] = num[start] - num[end];
        num[start] = num[start] - num[end];
    }
}
