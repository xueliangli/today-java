package javase.reflection.test;

import org.junit.jupiter.api.Test;

class TestForName {
    /**
     * forName 中加的是真实路径
     */
    @Test
    void testGetClassName() {
        try {
            Class stuClass = Class.forName("javase.domain.Student");
            System.out.println(stuClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
     * output :
     * com.xueliangli.domain.common.Student
     * */
}
