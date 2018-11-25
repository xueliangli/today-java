package com.xueliangli.collections.set;

import com.xueliangli.domain.Student;
import com.xueliangli.domain.StudentSet;
import com.xueliangli.utils.CollectionForUtil;
import org.junit.Test;

import java.util.Set;

public class MySet {
    /**
     * 重写的 hashCode 和 equals 方法一定要写在 Student 类中
     * */
    @Test
    public void testHashSet(){
        Set<Student> students = StudentSet.getStudentSet();
        CollectionForUtil.forEachMethod(students);
    }
}
