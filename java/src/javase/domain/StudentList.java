package javase.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentList {
    public static List<Student> getStudentList(){
        List<Student> studentList=new ArrayList<>();
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

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        return studentList;
    }

    public static List<Student> getStudentListLinked(){
        List<Student> studentList=new LinkedList<>();

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
        student4.setName("贾政");
        student4.setAge(60);
        student4.setPhoneNum("0000-0000");
        student4.setSex('男');

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        ((LinkedList<Student>) studentList).addFirst(student4);

        return studentList;
    }
}
