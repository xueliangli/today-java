package com.xueliangli.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * char[] toCharArray()
 *           将此字符串转换为一个新的字符数组。
 * */
public class API {
    private final String STR_1="abcddcbA";
    private final String STR_2="abcDDcba";
    private final String STR_3="as dasfa sfadf asefertf fgdh sdf s w";
    private final String STR_4="         ab   cDDcba                ";

    /**
     *  char charAt(int index)
     *           返回指定索引处的 char 值。
     * */
    @Test
    public void testMethod1(){
        System.out.println(STR_1.charAt(1));
    }

    /**
     *  int codePointAt(int index)
     *           返回指定索引处的字符（Unicode 代码点）。
     * */

    @Test
    public void testMethod2(){
        System.out.println(STR_1.charAt(2));
    }

    /**
     *   int compareToIgnoreCase(String str)
     *           按字典顺序比较两个字符串，不考虑大小写。
     *
     *           正确返回0
     * */
    @Test
    public void testMethod3(){
        System.out.println(STR_1.compareToIgnoreCase(STR_2));
    }

    /**
     *  String concat(String str)
     *           将指定字符串连接到此字符串的结尾。
     * */
    @Test
    public void testMethod4(){
        System.out.println(STR_1.concat("rrr"));
    }

    /**
     *  boolean contains(CharSequence s)
     *           当且仅当此字符串包含指定的 char 值序列时，返回 true。
     * */
    @Test
    public void testMethod5(){
        System.out.println(STR_1.contains("a"));
    }

    /**
     *   boolean endsWith(String suffix)
     *           测试此字符串是否以指定的后缀结束。
     * */
    @Test
    public void testMethod6(){
        System.out.println(STR_1.endsWith("cba"));
    }

    /**
     *   boolean equalsIgnoreCase(String anotherString)
     *           将此 String 与另一个 String 比较，不考虑大小写。
     * */

    @Test
    public void testMethod7(){
        System.out.println(STR_1.compareToIgnoreCase(STR_2));
    }

    /**
     *  byte[] getBytes()
     *           使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
     *           a对应的阿斯克码值为97
     *           A对应65
     *
     * */
    @Test
    public void testMethod8(){
        System.out.println(Arrays.toString(STR_1.getBytes()));
    }

    /**
     *  void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
     *           将字符从此字符串复制到目标字符数组。
     * */
    @Test
    public void testMethod9(){
        char[] charArray=new char[5];
        STR_1.getChars(0,2,charArray,0);
        System.out.println(charArray);
    }

    /**
     *  int indexOf(String str)
     *           返回指定子字符串在此字符串中第一次出现处的索引。
     * */
    @Test
    public void testMethod10(){
        System.out.println(STR_1.indexOf("d"));
    }

    /**
     *  int lastIndexOf(String str)
     *           返回指定子字符串在此字符串中最右边出现处的索引。
     * */
    @Test
    public void testMethod11(){
        System.out.println(STR_1.lastIndexOf("d"));
    }

    /**
     *  String[] split(String regex)
     *           根据给定正则表达式的匹配拆分此字符串。
     * */
    @Test
    public void testMethod12(){
        System.out.println(Arrays.toString(STR_3.split(" ")));
    }

    /**
     *   String substring(int beginIndex, int endIndex)
     *           返回一个新字符串，它是此字符串的一个子字符串。
     *
     *           end总是要+1使用
     * */
    @Test
    public void testMethod13(){
        System.out.println(Arrays.toString(new String[]{STR_1.substring(3, 5)}));
    }

    /**
     * String trim()
     *           返回字符串的副本，忽略前导空白和尾部空白。
     * */
    @Test
    public void testMethod14(){
        System.out.println(STR_4.trim());
    }


}
