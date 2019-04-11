/**
 * Author : xuan.
 * Date : 2019-04-11.
 * Description :N级台阶（比如100级），每次可走1步或者2步，求总共有多少种走法
 * 或者吃苹果
 *
 * 斐波那契数列
 */
class QA12 {
    public static int stepNum(int stair) {
        if (stair <= 0) {
            return 0;
        }
        if (stair == 1) {
            return 1;
        }
        if (stair == 2) {
            return 2;
        }
        return stepNum(stair - 1) + stepNum(stair - 2);
    }
}
