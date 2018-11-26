package com.xueliangli.domain.collections;

import com.xueliangli.domain.common.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentMap {
    public static Map<Integer,Student> getStudentMap(){
        Map<Integer, Student> studentMap = new HashMap<>();
        Student student1 = new Student();
        student1.setName("贾宝玉");
        student1.setAge(16);
        student1.setPhoneNum("0000-0000-0000");
        student1.setSex('男');

        Student student2 = new Student();
        student2.setName("林黛玉");
        student2.setAge(15);
        student2.setPhoneNum("0000-0000-0001");
        student2.setSex('女');

        Student student3 = new Student();
        student3.setName("薛宝钗");
        student3.setAge(17);
        student3.setPhoneNum("0000-0000-0002");
        student3.setSex('女');

        Student student4 = new Student();
        student4.setName("薛宝钗");
        student4.setAge(17);
        student4.setPhoneNum("0000-0000-0002");
        student4.setSex('女');

        Student student5 = new Student();
        student5.setName("袭人");
        student5.setAge(18);
        student5.setPhoneNum("0000-0000-0003");
        student5.setSex('女');

        Student student6 = new Student();
        student6.setName("袭人");
        student6.setAge(18);
        student6.setPhoneNum("0000-0000-0003");
        student6.setSex('女');

        studentMap.put(1,student1);
        studentMap.put(2,student2);
        studentMap.put(3,student3);
        studentMap.put(4,student4);
        studentMap.put(5,student5);
        studentMap.put(6,student6);

        return studentMap;
    }
}
