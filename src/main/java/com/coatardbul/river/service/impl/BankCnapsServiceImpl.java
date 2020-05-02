package com.coatardbul.river.service.impl;

import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.common.util.DataCacheUtil;
import com.coatardbul.river.mapper.BankCnapsMapper;
import com.coatardbul.river.model.entity.BankCnaps;
import com.coatardbul.river.service.BankCnapsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Service
@Slf4j
public class BankCnapsServiceImpl implements BankCnapsService {
    public static final String BRANCH_CODE = "branchCode";
    public static final String BRANCH_NAME = "branchName";
    public static final String BRANCH_ADDR = "branchAddr";
    @Autowired
    BankCnapsMapper bankCnapsMapper;
    @Autowired
    DataCacheUtil dataCacheUtil;

    /**
     * 解析zip文件
     *
     * @return
     */
    @Override
    public CommonResult parseFile() {
        ZipFile zip = null;
        InputStream inputSteam = null;
        try {
            //获取文件流
            zip = getZipFile();

            //获取zip文件中的每一个文件
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                log.info("解压的文件名：" + entry.getName() + "     文件大小：" + entry.getSize() + "字节");
                inputSteam = zip.getInputStream(entry);
                // 获取从csv文件中解析的信息，以及数据库的操作
                List<BankCnaps> bankCnaps = csvProcess(entry, inputSteam);
                // 操作数据库
                afterCall(bankCnaps);
            }
        } catch (IOException e) {
            log.info(e.getMessage(), e);
        }

        return null;
    }

    private void afterCall(List<BankCnaps> bankCnaps) {
        //获取BankCnaps中的数据
        Map<String, BankCnaps> bankCnapsMap = dataCacheUtil.getBankCnapsMap();
        for(BankCnaps b:bankCnaps){
            try {
                bankCnapsMapper.insert(b);
            }catch (Exception e){
               log.info(e.getMessage(),e);
            }
        }
     //   bankCnapsMapper.insertList(bankCnaps);

    }

    private List<BankCnaps> csvProcess(ZipEntry entry, InputStream inputSteam) throws IOException {

        CSVParser parser = CSVParser.parse(inputSteam, Charset.forName("GBK"), CSVFormat.DEFAULT.withHeader(BRANCH_CODE, BRANCH_NAME, BRANCH_ADDR));
        Iterator<CSVRecord> iterator = parser.iterator();
        //跳过前二行
        for (int i = 0; i < 2; i++) {
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        log.info("跳过" + entry.getName() + "文件的前二行");
        //获取第二行之后的数据
        List<BankCnaps> list = new ArrayList<>();
        BankCnaps bankCnaps = new BankCnaps();
        while (true) {
            try {
                if (iterator.hasNext()) {
                    CSVRecord record = iterator.next();
                    //文件格式 ：第一行 1.CNAPS号	2.银行名称	3.地址BRANCHNO  第三行数据
                    bankCnaps = new BankCnaps();
                    if (StringUtils.isEmpty(record.get(BRANCH_CODE))) {
                        continue;
                    }
                    bankCnaps.setCnapsCode(record.get(BRANCH_CODE).trim());
                    bankCnaps.setCnapsName(record.get(BRANCH_NAME));
                    bankCnaps.setCnapsAddr(record.get(BRANCH_ADDR));
                    list.add(bankCnaps);
                } else {
                    break;
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        return list;
    }

    private ZipFile getZipFile() throws IOException {
        //所创建文件的路径，将传入的流写入到文件中
        // String path = "D:" + File.separator + "var";
        String path = "C:\\Users\\coatardbul\\Desktop";
        //文件名及类型
        String fileName = "cnap.zip";
        File file = new File(path, fileName);
        ZipFile zipFile = new ZipFile(file, Charset.forName("GBK"));
        return zipFile;
    }

    @Override
    public int deleteByPrimaryKey(String cnapsCode) {
        return bankCnapsMapper.deleteByPrimaryKey(cnapsCode);
    }

    @Override
    public int insert(BankCnaps record) {
        return bankCnapsMapper.insert(record);
    }

    @Override
    public int insertSelective(BankCnaps record) {
        return bankCnapsMapper.insertSelective(record);
    }

    @Override
    public BankCnaps selectByPrimaryKey(String cnapsCode) {
        return bankCnapsMapper.selectByPrimaryKey(cnapsCode);
    }

    @Override
    public int updateByPrimaryKeySelective(BankCnaps record) {
        return bankCnapsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BankCnaps record) {
        return bankCnapsMapper.updateByPrimaryKey(record);
    }

}
