import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author : xuan.
 * Date : 2019-04-13.
 * Description :
 * 链接：https://www.nowcoder.com/questionTerminal/00de97733b8e4f97a3fb5c680ee10720
 * 来源：牛客网
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google
 * "时，第一个只出现一次的字符是"l"。
 * 输出字符串中的第一个不重复的字符
 */
class QA13 {
    /**
     * 利用LinkHashMap的有序性
     */
    private Map<Character, Integer> map = new LinkedHashMap<>();

    public void inser(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 0);
        }
    }

    public char FisrtAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
