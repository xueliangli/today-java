package TIJ4code;

/**
 * @program: java
 * @description: 四种初始化的方式
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-13 22:10
 **/
class Soap {
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    //需要重写 tostring 方法才能正确输出
    public String toString() {
        return s;
    }
}

public class A07_02 {
    //在定义处初始化
    private String s1 = "Happy", s2 = "Happy", s3, s4;
    //利用实例初始化
    private Soap castille;
    private int i;
    private float toy;

    //在构造器中初始化
    public A07_02() {
        System.out.println("Inside Bath()");
        s3 = "joy";
        toy = 3.14f;
        castille = new Soap();
    }

    {
        i = 47;
    }

    public String toString() {
        if (s4 == null) {
            s4 = "Joy";
        }
        return
                "s1 = " + s1 + "\n" +
                        "s2 = " + s2 + "\n" +
                        "s3 = " + s3 + "\n" +
                        "s4 = " + s4 + "\n" +
                        "i = " + i + "\n" +
                        "toy = " + toy + "\n" +
                        "castille = " + castille + "\n"
                ;
    }

    public static void main(String[] args) {
        A07_02 b = new A07_02();
        System.out.println(b);
    }
}
