package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 10:12
 **/
public class E01_08 {
    static class StaticTest {
        static int i = 47;
    }

    static class Incremenable {
        //静态方法
        static void increment() {
            StaticTest.i++;
        }
    }

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        StaticTest st3 = new StaticTest();
        StaticTest st4 = new StaticTest();
        System.out.println("st1.i = "+st1.i);
        System.out.println("st2.i = "+st2.i);
        System.out.println("st3.i = "+st3.i);
        System.out.println("st4.i = "+st4.i);
    }
}
