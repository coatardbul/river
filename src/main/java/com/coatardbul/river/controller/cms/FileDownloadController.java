/**
 * Copyright  2019-2029 联通集团财务有限公司版权所有。
 */
package com.coatardbul.river.controller.cms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author: suxiaolei
 * @date: 2019/7/25
 */
@Api(value = "下载信息")
@Slf4j
@RestController
@RequestMapping(value = "/download")
public class FileDownloadController {



    @ApiOperation(value = "下载文件信息", notes = "")
    @RequestMapping(value = "/downloadFile", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadFile(String fileType, HttpServletRequest request ){



        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in=null;
        try {
            in=new FileInputStream(new File("C:\\Users\\coatardbul\\Desktop\\cc.csv"));

            byte[] bytes = new byte[in.available()];

//            String imageName="001.png";

//            //处理IE下载文件的中文名称乱码的问题
//            String header = request.getHeader("User-Agent").toUpperCase();
//            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
//                imageName = URLEncoder.encode(imageName, "utf-8");
//                imageName = imageName.replace("+", "%20");    //IE下载文件名空格变+号问题
//            } else {
//                imageName = new String(imageName.getBytes(), "iso-8859-1");
//            }

            in.read(bytes);

          //  headers.add("Content-Disposition", "attachment;filename="+imageName);
          //  entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
            entity = new ResponseEntity<byte[]>(bytes,  HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return entity;
    }


}
