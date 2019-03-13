package TIJ4code;

/**
 * @program: java
 * @description:
 * @analysis:
 * @author: 李学亮    email: 18222027300@163.com
 * @create: 2019-03-07 09:51
 **/
public class E01_06 {
    public static void main(String[] args) {
        class StoreStuff{
            int storage(String s){
                return s.length()*2;
            }
        }
        StoreStuff st=new StoreStuff();
        System.out.println(st.storage("   "));
    }
}
