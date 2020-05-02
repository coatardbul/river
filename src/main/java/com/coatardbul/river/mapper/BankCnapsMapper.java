package com.coatardbul.river.mapper;

import com.coatardbul.river.model.entity.BankCnaps;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankCnapsMapper {
    int deleteByPrimaryKey(String cnapsCode);

    int insert(BankCnaps record);

    int insertList(@Param("list") List<BankCnaps> list);

    int insertSelective(BankCnaps record);

    BankCnaps selectByPrimaryKey(String cnapsCode);

    int updateByPrimaryKeySelective(BankCnaps record);

    int updateByPrimaryKey(BankCnaps record);

    List<BankCnaps> selectByAll(BankCnaps bankCnaps);


}