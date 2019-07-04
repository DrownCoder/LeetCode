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

    /**
     * 斐波那契数列
     */
    public static int stepNum2(int stair) {
        if (stair <= 0) {
            return 0;
        }
        //一个台阶走一步
        if (stair == 1) {
            return 1;
        }
        //两个台阶两种走法
        if (stair == 2) {
            return 2;
        }
        //每次走一步，剩下的再递归+每次走两步剩下的再递归
        return stepNum2(stair - 1) + stepNum2(stair - 2);
    }
}
