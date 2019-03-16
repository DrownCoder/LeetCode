package must;

/**
 * Author : xuan.
 * Date : 2019-03-16.
 * Description :the description of this file
 */
class JudgePrime {
    /**
     * 判断是否是素数
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
