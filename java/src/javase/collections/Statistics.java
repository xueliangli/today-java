package javase.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 随机产生范围0到19的10000个数，统计出现的数字的个数并输出
 */
public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(20);
            Integer value = m.get(key);
            m.put(key, value == null ? 1 : value + 1);
        }
        System.out.println(m);
    }
}
