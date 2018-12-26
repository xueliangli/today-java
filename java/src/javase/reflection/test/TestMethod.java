package javase.reflection.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class TestMethod {
    /**
     * 获取成员方法并调用
     */
    @Test
    void testGetMethod() throws Exception {
        Class<?> stuClass = Class.forName("javase.domain.Student");
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
}
