package javase.reflection;

import javase.collections.Student;
import javase.utils.ReflectionUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class API {
    /**
     * forName 中加的是真实路径
     */
    @Test
    void testGetClassName() {
        try {
            Class stuClass = Class.forName("com.xueliangli.domain.common.Student");
            System.out.println(stuClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
     * output :
     * com.xueliangli.domain.common.Student
     * */

    /**
     * 获取构造方法
     */
    @Test
    void testGetConstructor() throws Exception {
        //获得类对象
        Class<?> studentClass = Class.forName("com.xueliangli.domain.common.Student");
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


    /**
     * 通过构造器赋值
     */
    @Test
    void testGetField() throws Exception {
        //获得类对象
        Class<?> studentClass = Class.forName("com.xueliangli.domain.common.Student");
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


    /**
     * 获取成员方法并调用
     */
    @Test
    void testGetMethod() throws Exception {
        Class<?> stuClass = Class.forName("com.xueliangli.domain.common.Student");
        Method setName = stuClass.getMethod("setName", String.class);
        Method getName = stuClass.getMethod("getName");
        Object stuObj = stuClass.getConstructor().newInstance();
        //stuObj 位置是要调用该方法的对象
        setName.invoke(stuObj, "贾宝玉");
        Object name = getName.invoke(stuObj);
        System.out.println(name);
    }
    /*
     * output :
     * 贾宝玉
     * */


    /**
     * 反射 main 方法
     * ??????????????????????????
     */
    @Test
    void testGetMain() throws Exception {
//        Class<?> stuClass = Class.forName("com.xueliangli.domain.common.Student");
//        Method mainMethod = stuClass.getMethod("main", String[].class);
//        String[] strings={"a","b"};
//        mainMethod.invoke(null, (Object)strings);
    }


    /**
     * 找不到setAge方法，不知道原因
     *？？？？？？？？？？？？？？？？？？？？？？？？？
     * */
    @Test
    void testGetProperties() throws Exception {
        Class<?> stuClass = Class.forName(ReflectionUtil.getValue("className"));
        Method setAge = stuClass.getMethod(ReflectionUtil.getValue("setAge"));
        Method getAge = stuClass.getMethod(ReflectionUtil.getValue("getAge"));
        Object stuObj = stuClass.getConstructor().newInstance();
        setAge.invoke(stuObj,"贾宝玉");
        Object name = getAge.invoke(stuObj);
        System.out.println(name);
    }

    /**
     * 通过反射越过泛型检查，待补充
     * ？？？？？？？？？？？？？？？？？？？？？？
     */
    @Test
    void testOverT() {

    }

}
