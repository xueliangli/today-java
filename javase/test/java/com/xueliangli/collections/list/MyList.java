package com.xueliangli.collections.list;

import com.xueliangli.domain.Student;
import com.xueliangli.domain.StudentList;
import com.xueliangli.utils.CollectionForUtil;
import org.junit.Test;

import java.util.Collection;

public class MyList {

    @Test
    public void testArrayList() {
        Collection<Student> studentList = StudentList.getStudentList();
        CollectionForUtil.forEachMethod(studentList);
        System.out.println("==========================");
        CollectionForUtil.iteratorMethod(studentList);
    }


    @Test
    public void testLinkedList(){
        Collection<Student> students=StudentList.getStudentListLinked();
        CollectionForUtil.iteratorMethod(students);
    }



}
