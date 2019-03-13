package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 09:37
 **/
public class E01_03 {
    //需要静态表示，不然访问不到
    private static class ATypeName{
        private int i;
        private double d;
        private boolean b;
        private void show(){
            System.out.println(i);
            System.out.println(d);
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        ATypeName a=new ATypeName();
        a.b=true;
        a.d=0.0;
        a.i=0;
        a.show();
    }
}
