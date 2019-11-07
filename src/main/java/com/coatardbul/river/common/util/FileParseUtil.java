package com.coatardbul.river.common.util;

import com.coatardbul.river.model.entity.BedcBankbranch;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileParseUtil {
    public static final String BRANCH_CODE = "branchCode";
    public static final String BRANCH_NAME = "branchName";
    public static final String BRANCH_ADDR = "branchAddr";
    public static void main(String[] args) throws Exception {
        File ff = new File("C:\\Users\\coatardbul\\Desktop\\cnap.zip");

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in = null;
        try {
            in = new FileInputStream(ff);
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);


            byte[] body = entity.getBody();


            InputStream inputStream = new ByteArrayInputStream(body);
            String path = "C:\\Users\\coatardbul\\Desktop";//所创建文件的路径
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();//创建目录
            }
            String fileName = "hello.zip";//文件名及类型
            File file = new File(path, fileName);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(body);

            ZipFile zip = new ZipFile(file, Charset.forName("GBK"));

            for(Enumeration entries = zip.entries(); entries.hasMoreElements();)
            {
                ZipEntry entry = (ZipEntry)entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream inputSteamTemp = zip.getInputStream(entry);


                List<BedcBankbranch> list = new ArrayList<>();
                CSVParser parser = CSVParser.parse(inputSteamTemp, Charset.forName("GBK"), CSVFormat.DEFAULT.withHeader(BRANCH_CODE, BRANCH_NAME,BRANCH_ADDR));
                int i=0;
                int j=0;
                BedcBankbranch bedcBankbranch = new BedcBankbranch();
                for (final CSVRecord record : parser) {
                    if(++j<3){
                       continue;
                    }
                    bedcBankbranch = new BedcBankbranch();
                    //银行联行号，前三位为银行代码
                    bedcBankbranch.setBankcode(record.get(BRANCH_CODE).substring(0, 3));
                    bedcBankbranch.setBranchcode(record.get(BRANCH_NAME));
                  // bedcBankbranch.setBranchcode(record.get(BRANCH_CODE));
                    bedcBankbranch.setBranchno(record.get(BRANCH_ADDR));
                    //.4位城市代码
                    bedcBankbranch.setPlatprocode(record.get(BRANCH_CODE).substring(3, 7));
                    System.out.println(++i+":"+bedcBankbranch.toString());
                    list.add(bedcBankbranch);
                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     *解析单个文件
     */
    @Test
    public  void parseFile() throws Exception {
        File ff = new File("C:\\Users\\coatardbul\\Desktop\\cnap1.csv");
        FileInputStream fileInputStream=new FileInputStream(ff);
        CSVParser parser = CSVParser.parse(fileInputStream, Charset.forName("GBK"), CSVFormat.DEFAULT.withHeader(BRANCH_CODE, BRANCH_NAME));
        List<BedcBankbranch> list = new ArrayList<>();
        BedcBankbranch bedcBankbranch = new BedcBankbranch();
        for (final CSVRecord record : parser) {
            record.get(BRANCH_NAME);
            record.get(BRANCH_CODE);

//            bedcBankbranch = new BedcBankbranch();
//            //银行联行号，前三位为银行代码
//            bedcBankbranch.setBankcode(record.get(BRANCH_CODE).substring(0, 3));
//            bedcBankbranch.setBranchcode(record.get(BRANCH_NAME));
//            bedcBankbranch.setBranchcode(record.get(BRANCH_CODE));
//            //.4位城市代码
//            bedcBankbranch.setPlatprocode(record.get(BRANCH_CODE).substring(3, 7));
//            list.add(bedcBankbranch);
        }

    }
}
