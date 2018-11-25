package com.xueliangli.io;

import com.xueliangli.utils.IoTxtListConvertUtil;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 将字符串文本读入，放到list中，打乱顺序，再写入到新的文件中
 */
public class testIo {

    /**
     * 将排好序的文本，乱序后再输出
     * */
    @Test
    public void testTxtListConvert() throws Exception {
        String srcFile="././resources/test-resource/sort-test-100000-words-sorted.txt";
        String destFile="././resources/test-resource/sort-test-100000-words-new.txt";
        IoTxtListConvertUtil.getNewTxt(srcFile,destFile);
    }
}
