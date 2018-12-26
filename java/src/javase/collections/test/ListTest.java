package javase.collections.test;

import javase.collections.utils.CollectionForUtil;
import javase.domain.Student;
import javase.domain.StudentList;
import org.junit.jupiter.api.Test;

import java.util.Collection;

class ListTest {

    @Test
    void testArrayList() {
        Collection<Student> studentList = StudentList.getStudentList();
        CollectionForUtil.forEachMethod(studentList);
        System.out.println("==========================");
        CollectionForUtil.iteratorMethod(studentList);
    }

    @Test
    void testLinkedList() {
        Collection<Student> students = StudentList.getStudentListLinked();
        CollectionForUtil.iteratorMethod(students);
    }


}
