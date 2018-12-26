package javase.collections.utils;

import javase.domain.Student;

import java.util.Collection;
import java.util.Iterator;

public class CollectionForUtil {
    /**
     * 增强 for 循环遍历
     * */
    public static void forEachMethod(Collection<Student> studentList) {
        //增强 for 循环的遍历方法
        for (Student student : studentList) {
            System.out.println(student);
        }
    }


    /**
     * 迭代器遍历
     * */
    public static void iteratorMethod(Collection<Student> studentList) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
