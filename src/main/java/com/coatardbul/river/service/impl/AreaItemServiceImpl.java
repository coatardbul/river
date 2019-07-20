package com.coatardbul.river.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.coatardbul.river.model.entity.AreaItem;
import com.coatardbul.river.mapper.AreaItemMapper;
import com.coatardbul.river.service.AreaItemService;
@Service
public class AreaItemServiceImpl implements AreaItemService{

    @Resource
    private AreaItemMapper areaItemMapper;

    @Override
    public int deleteByPrimaryKey(String code,String name) {
        return areaItemMapper.deleteByPrimaryKey(code,name);
    }

    @Override
    public int insert(AreaItem record) {
        return areaItemMapper.insert(record);
    }

    @Override
    public int insertSelective(AreaItem record) {
        return areaItemMapper.insertSelective(record);
    }

    @Override
    public AreaItem selectByPrimaryKey(String code,String name) {
        return areaItemMapper.selectByPrimaryKey(code,name);
    }

    @Override
    public int updateByPrimaryKeySelective(AreaItem record) {
        return areaItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AreaItem record) {
        return areaItemMapper.updateByPrimaryKey(record);
    }

}
