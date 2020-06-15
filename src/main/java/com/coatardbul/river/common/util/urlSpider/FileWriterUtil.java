package com.coatardbul.river.common.util.urlSpider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    public static void writerObject(String fileInfo) throws IOException {
        String fileUrl = "C:\\Users\\coatardbul\\Desktop\\信息.txt";
        File f = new File(fileUrl);
        if (f.exists()) {
            f.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(fileInfo);
        bw.close();
    }

}
