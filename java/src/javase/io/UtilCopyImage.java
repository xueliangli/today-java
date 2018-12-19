package javase.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*************************************************************************
 *
 * 复制图片到指定目录：
 * 一次读取一个字节数组或者一次读取一个字节数组
 *
 * 思路:
 * 1、创建字节流对象
 * 2、一次读取一个字节数组 byte[] ,变量 len 存放读到的字节个数
 * 3、释放资源
 *************************************************************************/
public class UtilCopyImage {
    private static void copyImage(String src, String dest) throws Exception {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();
    }

    public static void main(String[] args) throws Exception {
        String src = "D:\\today-java\\java\\resources\\img\\idea重复代码警告设置处.PNG";
        String dest = "D:\\today-java\\java\\resources\\img\\idea重复代码警告设置处111.PNG";
        copyImage(src, dest);
    }
}
