package com.xueliangli.utils;

import java.io.FileReader;
import java.util.Properties;

public class ReflectionUtil {
    /**
     * 通过配置文件，输入健的名字，返回值
     * */
    public static String getValue(String key) throws Exception {
        //配置文件对象
        Properties properties = new Properties();
        //输入流
        FileReader in = new FileReader("D:\\today-java\\javase\\src\\main\\resources\\reflection\\ref.properties");
        //将流加载到配置文件对象
        properties.load(in);
        in.close();
        //返回根据key得到的value值
        return properties.getProperty(key);
    }
}
