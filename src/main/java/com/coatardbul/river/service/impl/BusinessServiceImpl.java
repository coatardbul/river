package com.coatardbul.river.service.impl;

import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.common.util.DataCacheUtil;
import com.coatardbul.river.mapper.BankCnapsMapper;
import com.coatardbul.river.model.entity.BankCnaps;
import com.coatardbul.river.service.BusinessService;
import com.coatardbul.river.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    BankCnapsMapper bankCnapsMapper;
    @Autowired
    CommonService commonService;
    @Autowired
    DataCacheUtil dataCacheUtil;

    /**
     * 获取初始化的BankCnaps数据
     *
     * @return
     */
    @Override
    public CommonResult getInitBankCnapsMap() {
        List<BankCnaps> bankCnaps = bankCnapsMapper.selectByAll(null);
        Map cnapsCode = null;
        try {
            cnapsCode = commonService.convertListToMap("cnapsCode", bankCnaps);
            return CommonResult.success(cnapsCode);
        } catch (IllegalAccessException e) {
            log.info(e.getMessage(), e);
            return CommonResult.failed("转换异常");
        }

    }
}
