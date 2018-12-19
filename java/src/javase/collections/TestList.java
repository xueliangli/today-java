package javase.collections;

import org.junit.jupiter.api.Test;

import java.util.Collection;

class TestList {

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
