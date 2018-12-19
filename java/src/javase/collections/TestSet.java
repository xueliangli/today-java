package javase.collections;

import org.junit.jupiter.api.Test;

import java.util.Set;

class TestSet {
    /**
     * 重写的 hashCode 和 equals 方法一定要写在 Student 类中
     * */
    @Test
    void testHashSet(){
        Set<Student> students = StudentSet.getStudentSet();
        CollectionForUtil.forEachMethod(students);
    }
}
