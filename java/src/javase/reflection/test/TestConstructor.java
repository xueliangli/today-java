package javase.reflection.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class TestConstructor {
    /**
     * 获取构造方法
     */
    @Test
    void testGetConstructor() throws Exception {
        //获得类对象
        Class<?> studentClass = Class.forName("javase.domain.Student");
        Constructor<?>[] pubCons = studentClass.getConstructors();
        for (Constructor con :
                pubCons) {
            System.out.println(con);
        }

        //填构造器方法参数的类型
        Constructor<?> declaredConstructor = studentClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);

        //暴力获取法
        declaredConstructor.setAccessible(true);//忽略访问修饰符
        //传给构造器参数
        declaredConstructor.newInstance("李学亮", 23);

    }
    /*
      output :
    * public com.xueliangli.domain.common.Student(java.lang.String,int,java.lang.String)
      public com.xueliangli.domain.common.Student(java.lang.String)
      private com.xueliangli.domain.common.Student(java.lang.String,int)
      姓名李学亮年龄23
    * */
}
