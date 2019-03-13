package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 09:52
 **/
public class E01_07 {
    static class StaticTest {
        static int i = 47;
    }

    static class Incremenable {
        //静态方法
        static void increment() {
            StaticTest.i++;
        }

        //非静态方法
        void increment2() {
            StaticTest.i++;
        }
    }

    public static void main(String[] args) {
        System.out.println("StaticTest.i= " + StaticTest.i);
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println("st1.i= " + st1.i);
        System.out.println("st2.i= " + st2.i);
        //注意静态方法的
        Incremenable inc = new Incremenable();
        inc.increment();
        inc.increment2();
        //通过类名直接调用
        Incremenable.increment();
        System.out.println("after Inc.i= " + StaticTest.i);
    }
}
