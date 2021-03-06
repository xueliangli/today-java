package com.xueliangli.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class IoTxtListConvertUtil {
    public static void getNewTxt(String srcFile,String destFile) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile));

        String line;

        ArrayList<String> strings = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String temp = line.trim();
            if (!"".equals(temp)) {
                strings.add(temp);
            }
        }

        bufferedReader.close();
        Collections.shuffle(strings);

        for (String s : strings) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
    }
}
