package com.coatardbul.river.service;

import com.coatardbul.river.model.entity.AreaItem;

import java.util.List;

public interface AreaItemService {


    int deleteByPrimaryKey(String code, String name);

    int insert(AreaItem record);

    int insertSelective(AreaItem record);

    List<AreaItem> selectByPrimaryKey(String code, String name);

    int updateByPrimaryKeySelective(AreaItem record);

    int updateByPrimaryKey(AreaItem record);

}
