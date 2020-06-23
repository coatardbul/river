package com.coatardbul.river.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.coatardbul.river.mapper.BankCnapsMapper;
import com.coatardbul.river.model.entity.BankCnaps;
import com.coatardbul.river.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@EnableAspectJAutoProxy(exposeProxy = true)

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    BankCnapsMapper bankCnapsMapper;

    @Transactional
    @Override
    public void insertTransaction() {
        try {
//           ((TransactionService) AopContext.currentProxy()).
//                    childInsert();

            ((TransactionServiceImpl) AopContext.currentProxy()).
                    childInsertNoOverride();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }

        BankCnaps b = new BankCnaps();
        b.setCnapsCode("123456789012");
        b.setCnapsName("111111111111");
        b.setCnapsAddr("111111111111111");
        b.setCreateTime(new Date());
        b.setLastUpdateTime(new Date());


        bankCnapsMapper.insert(b);

        List list = new ArrayList();

//        list.get(3);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public
        //(propagation = Propagation.REQUIRES_NEW)
    void childInsert() {
        BankCnaps b = new BankCnaps();
        b.setCnapsCode("123456789011");
        b.setCnapsName("22222222222222");
        b.setCnapsAddr("22222222222222222222222222");
        b.setCreateTime(new Date());
        b.setLastUpdateTime(new Date());

        bankCnapsMapper.insert(b);
        List list = new ArrayList();

        int i = 1 / 0;

    }
    @Transactional
    void childInsertNoOverride() {
        BankCnaps b = new BankCnaps();
        b.setCnapsCode("123456789010");
        b.setCnapsName("22222222222222");
        b.setCnapsAddr("22222222222222222222222222");
        b.setCreateTime(new Date());
        b.setLastUpdateTime(new Date());

        bankCnapsMapper.insert(b);
        List list = new ArrayList();

        int i = 1 / 0;

    }
}
