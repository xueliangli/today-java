package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 09:50
 **/
public class E01_05 {
    public static void main(String[] args) {
        class DataOnly{
            int i;
            double d;
            boolean b;
            void show(){
                System.out.println(i);;
                System.out.println(d);
                System.out.println(b);
            }
        }
        DataOnly a=new DataOnly();
        a.b=true;
        a.d=0.0;
        a.i=0;
        a.show();
    }
}
