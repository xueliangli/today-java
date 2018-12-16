package javase.utils;

import javase.collections.Student;

import java.util.Map;
import java.util.Set;

public class MapForUtil {
    public static void keySetMethod(Map<Integer, Student> studentMap) {
        Set<Integer> keys = studentMap.keySet();
        for (int key:keys) {
            Student student = studentMap.get(key);
            System.out.println("key:"+key+"-----"+"student:"+student);
        }
    }

    /**
     * Map.Entry<K, V> 是一个接口，一个 Map.entrySet() 返回的映射项
     * */
    public static void entrySetMethod(Map<Integer, Student> studentMap) {
        Set<Map.Entry<Integer, Student>> entries = studentMap.entrySet();
        for (Map.Entry<Integer, Student> entry:entries) {
            Integer key = entry.getKey();
            Student student = entry.getValue();
            System.out.println("key:"+key+"-----"+"student:"+student);
        }
    }
}
