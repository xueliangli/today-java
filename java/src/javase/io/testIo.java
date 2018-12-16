package javase.io;

import javase.utils.IoTxtListConvertUtil;
import org.junit.jupiter.api.Test;

/**
 * 将字符串文本读入，放到list中，打乱顺序，再写入到新的文件中
 */
class testIo {

    /**
     * 将排好序的文本，乱序后再输出
     * */
    @Test
    void testTxtListConvert() throws Exception {
        String srcFile="././././src/main/resources/test-resource/sort-test-100000-words-sorted.txt";
        String destFile="././././src/main/resources/test-resource/sort-test-100000-words-new.txt";
        IoTxtListConvertUtil.getNewTxt(srcFile,destFile);
    }
}
