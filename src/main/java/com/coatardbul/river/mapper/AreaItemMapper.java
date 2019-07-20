package com.coatardbul.river.mapper;

import com.coatardbul.river.model.entity.AreaItem;
import org.apache.ibatis.annotations.Param;

public interface AreaItemMapper {
    int deleteByPrimaryKey(@Param("code") String code, @Param("name") String name);

    int insert(AreaItem record);

    int insertSelective(AreaItem record);

    AreaItem selectByPrimaryKey(@Param("code") String code, @Param("name") String name);

    int updateByPrimaryKeySelective(AreaItem record);

    int updateByPrimaryKey(AreaItem record);
}