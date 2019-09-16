/**
 * Author : xuan.
 * Date : 2019-09-16.
 * Description :如果将一个二进制数-1，那么该二进制数最右侧的1将会变成0,1后面的0均变成1,1前面的数保持不变
 *
 * 也就是说，如果把一个二进制数-1，那么概述最右侧的1及1右侧的所有书将改变（0-->1或者1--->0）
 *
 * 如果把这个数和原数进行与运算，那么最右侧的那个1前面的1将不变，1以及1右侧的所有书将变成0，也就是说进行一次上述运算后，原数最右侧的那个1会变成0，那么只要重复上述操作，当原数变成0
 * 时，循环就是1的个数
 * ————————————————
 * 版权声明：本文为CSDN博主「kingdoooom」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/kuangsonghan/article/details/78791271
 *
 * 十进制中二进制的1的个数
 */
class QA31 {
    public static void main(String[] args) {

    }

    public static int get1Number(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
