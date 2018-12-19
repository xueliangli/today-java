package javase.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/*************************************************************************
 *
 * 案例1：输出全盘 .java 类型的文件，包含子目录的文件名称
 * 并将其存放到一个 .txt 文件中
 *
 * 思路分析：
 * 1、得到整个盘符
 * 2、依次遍历每个盘符找出子目录下以 .java 结尾的文件
 * 3、打印到控制台
 * 4、通过 io 流存放到文件中
 *
 * 还有很多可扩展性，可以制作成一个小工具
 *
 *************************************************************************/
public class UtilPrintFileName {
    //必须定义为全局变量
    private static ArrayList<String> strings = new ArrayList<>();
    /**
     * 寻找目录中指定格式的文件
     * @param file 想要得到的目录名
     */
    private static void getFileName(File file) {
        //判断是否是目录
        if (file.isDirectory()) {
            //若果是，通过Api得到所有文件，存放到相应数组中
            File[] files = file.listFiles();
            if (files==null)
                files=File.listRoots();
            //遍历所有文件
            for (File f : files) {
                if (f.isFile()) {
                    //判断是否是文件，判断是否以 .java 结尾
                    if (f.getName().endsWith(".java")) {
                        strings.add(f.getName());
                    }
                }else if (f.isDirectory()){
                    getFileName(f);
                }
            }
        }
    }

    /**
     * 将文件名写入到指定的文件中
     * @param strings 动态数据作为数据源
     * @param destFile 目标文件名
     * */
    private static void writeToFile(ArrayList<String> strings,String destFile) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
        for (String s : strings) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\today-java");
        getFileName(file);
        String destFile="D:\\today-java\\java\\src\\javase\\io\\new.txt";
        writeToFile(strings,destFile);
    }
}
