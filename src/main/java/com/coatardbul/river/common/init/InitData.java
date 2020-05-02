package com.coatardbul.river.common.init;

import com.coatardbul.river.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
@Slf4j
public class InitData {
    @Autowired
    BusinessService businessService;

    @PostConstruct
    public void InitCache() {
        log.info("项目启动时开始加载数据：");
        businessService.getInitBankCnapsMap();
        log.info("项目启动时数据加载线束");

    }

}
