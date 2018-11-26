package com.xueliangli.collections.map;

import com.xueliangli.domain.common.Student;
import com.xueliangli.domain.collections.StudentMap;
import com.xueliangli.utils.MapForUtil;
import org.junit.Test;

import java.util.Map;

public class MyMap {

    @Test
    public void testHashMap(){
        Map<Integer, Student> studentMap = StudentMap.getStudentMap();

        MapForUtil.keySetMethod(studentMap);

        System.out.println("===========================");

        MapForUtil.entrySetMethod(studentMap);
    }


}
