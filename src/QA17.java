/**
 * Author : xuan.
 * Date : 2019-05-22.
 * Description :
 * 70.
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
class QA17 {
    public static void main(String[] args) {
        System.out.println(climbStair3(5));
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pointA = 1;
        int pointB = 2;
        int num = 0;
        for (int i = 2; i < n; i++) {
            num = pointA + pointB;
            pointA = pointB;
            pointB = num;
        }
        return num;
    }

    /**
     * 1
     * 0+1 = 1
     * 2
     * 1+1 = 2
     * 3
     * 2+1 = 3
     * 4
     * 3+2 =5
     * 5
     * 5+3 = 8
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int num = 0;
        for (int i = 3; i <= n; i++) {
            num = a + b;
            a = b;
            b = num;
        }
        return num;
    }

    public static int climbStair3(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStair3(n - 1) + climbStair3(n - 2);
    }
}
