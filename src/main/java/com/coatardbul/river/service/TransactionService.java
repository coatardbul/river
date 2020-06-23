package com.coatardbul.river.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionService {


    void insertTransaction();

    void childInsert();
}
