package com.coatardbul.river.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 银行联行号信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCnaps {
    /**
     * 银行联行号
     */
    private String cnapsCode;

    /**
     * 联行号名称
     */
    private String cnapsName;

    /**
     * 行号地址
     */
    private String cnapsAddr;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;
}