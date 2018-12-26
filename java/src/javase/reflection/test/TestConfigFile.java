package javase.reflection.test;

import javase.reflection.utils.ReflectionUtil;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
/**
 * FIXME ：李学亮，2018/12/26，寒假期间
 * 未测试成功,报错：NoSuchMethodException: javase.domain.Student.setName()
 * */
class TestConfigFile {
    @Test
    void testGetProperties() throws Exception {
        Class<?> stuClass = Class.forName(ReflectionUtil.getValue("className"));
        Method setAge = stuClass.getMethod(ReflectionUtil.getValue("setName"));
        Method getAge = stuClass.getMethod(ReflectionUtil.getValue("getName"));
        Object stuObj = stuClass.getConstructor().newInstance();
        setAge.invoke(stuObj,"贾宝玉");
        Object name = getAge.invoke(stuObj);
        System.out.println(name);
    }
}
