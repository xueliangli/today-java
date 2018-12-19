package javase.collections;

import org.junit.jupiter.api.Test;

import java.util.Map;

class TestMap {

    @Test
    void testHashMap(){
        Map<Integer, Student> studentMap = StudentMap.getStudentMap();

        MapForUtil.keySetMethod(studentMap);

        System.out.println("===========================");

        MapForUtil.entrySetMethod(studentMap);
    }


}
