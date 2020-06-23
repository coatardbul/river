package com.coatardbul.river.controller.local;


import com.coatardbul.river.common.annotation.WebLog;
import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

@Api(value = "银行联行号信息")
@WebLog("1111111")
@Slf4j
@RestController
@RequestMapping(value = "/query")
public class SpiderController {
    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "爬取数据", notes = "爬取数据")
    @RequestMapping(value = "/spiderBankBranchInfo", method = RequestMethod.POST)
    public CommonResult spiderBankBranchInfo() throws ExecutionException, InterruptedException, InvocationTargetException, IllegalAccessException, IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(30);

//        BankBranchParseUtil b = new BankBranchParseUtil();
//        //获取省市请求url
//        List<String> urlList = b.getUrlListByProvinceNum(BankBranchParseUtil.NUM);
//
//        ProvinceCItyCountTask p = new ProvinceCItyCountTask(urlList);
//        List<ProvinceCItyInfo> allList = forkJoinPool.submit(p).get();
//        //根据请求的url集合获取所有的省市信息
//        // List<ProvinceCItyInfo> allList = b.getProvinceCItyInfos(urlList);
//        Map<String, ProvinceCItyInfo> mapProvinceCItyInfo = b.getMapProvinceCItyInfo(allList);
//        //将省市信息转换成   html url的集合
//        List<UrlProvinceCItyInfo> list = b.convertProvinceCityInfoToHtmlUrl(allList);
//
//
//        UrlBankBranchTask urlBankBranchTask = new UrlBankBranchTask(list);
//        ForkJoinPool forkJoinPool1 = new ForkJoinPool(30);
//        List<BankBranchCollectionInfo> bankBranchCollectionInfos = forkJoinPool1.submit(urlBankBranchTask).get();
//        //一个市对应的联行号信息
//        String s = b.convertList(bankBranchCollectionInfos, mapProvinceCItyInfo);
//        System.out.println(bankBranchCollectionInfos.size());
//        FileWriterUtil.writerObject(s);
        return null;
    }
}
