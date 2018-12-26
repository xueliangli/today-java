package javase.collections.test;

import javase.collections.utils.CollectionForUtil;
import javase.domain.Student;
import javase.domain.StudentSet;
import org.junit.jupiter.api.Test;

import java.util.Set;

class SetTest {
    /**
     * 重写的 hashCode 和 equals 方法一定要写在 Student 类中
     * */
    @Test
    void testHashSet(){
        Set<Student> students = StudentSet.getStudentSet();
        CollectionForUtil.forEachMethod(students);
    }
}
