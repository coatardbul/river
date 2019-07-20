package com.coatardbul.river.service;

import com.coatardbul.river.model.entity.AreaItem;
public interface AreaItemService{


    int deleteByPrimaryKey(String code,String name);

    int insert(AreaItem record);

    int insertSelective(AreaItem record);

    AreaItem selectByPrimaryKey(String code,String name);

    int updateByPrimaryKeySelective(AreaItem record);

    int updateByPrimaryKey(AreaItem record);

}
