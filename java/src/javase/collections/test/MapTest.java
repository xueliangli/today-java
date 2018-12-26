package javase.collections.test;

import javase.collections.utils.MapForUtil;
import javase.domain.Student;
import javase.domain.StudentMap;
import org.junit.jupiter.api.Test;

import java.util.Map;

class MapTest {

    @Test
    void testHashMap(){
        Map<Integer, Student> studentMap = StudentMap.getStudentMap();

        MapForUtil.keySetMethod(studentMap);

        System.out.println("===========================");

        MapForUtil.entrySetMethod(studentMap);
    }


}
