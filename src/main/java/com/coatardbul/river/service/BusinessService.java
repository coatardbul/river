package com.coatardbul.river.service;

import com.coatardbul.river.common.api.CommonResult;

public interface BusinessService {

    /**
     * 获取初始化的BankCnaps数据
     * @return
     */
    public CommonResult getInitBankCnapsMap();
}
