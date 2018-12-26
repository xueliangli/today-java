package javase.reflection.test;

import javase.domain.Student;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class TestAssign {
    /**
     * 通过构造器赋值
     */
    @Test
    void testGetField() throws Exception {
        //获得类对象
        Class<?> studentClass = Class.forName("javase.domain.Student");
        //产生一个stu对象
        Constructor stuCon = studentClass.getConstructor(String.class, int.class, char.class, String.class);
        Object stuObj = stuCon.newInstance("贾宝玉", 16, '男', "18222027300");
        //获取私有成员变量
//        Field name = studentClass.getDeclaredField("name");
//        Field sex = studentClass.getDeclaredField("sex");
//        Field age = studentClass.getDeclaredField("age");
//        Field phoneNum = studentClass.getDeclaredField("phoneNum");
        //传递参数
        Student stu = (Student) stuObj;

//        name.set(stuObj,"贾宝玉");
//        sex.set(stuObj,'男');
//        age.set(stuObj,16);
//        phoneNum.set(stuObj,"18222027300");
        //打印 stu 对象
        System.out.println(stu);
    }
    /*
     * exception : java.lang.IllegalArgumentException: wrong number of arguments newInstance 参数没有设置
     * output :
     * Student{name='贾宝玉', age=16, sex=男, phoneNum='18222027300'}
     * */
}
