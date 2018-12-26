package javase.domain;

import java.util.HashSet;
import java.util.Set;

public class StudentSet {
    public static Set<Student> getStudentSet(){
        HashSet<Student> students=new HashSet<>();
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

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        return students;
    }


}
