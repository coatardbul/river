package com.coatardbul.river.service;

import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.model.entity.BankCnaps;

public interface BankCnapsService{
    /**
     * 解析zip文件
     * @return
     */
    CommonResult parseFile() ;
    int deleteByPrimaryKey(String cnapsCode);

    int insert(BankCnaps record);

    int insertSelective(BankCnaps record);

    BankCnaps selectByPrimaryKey(String cnapsCode);

    int updateByPrimaryKeySelective(BankCnaps record);

    int updateByPrimaryKey(BankCnaps record);

}
