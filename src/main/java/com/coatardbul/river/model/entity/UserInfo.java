package com.coatardbul.river.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     * 主键id
     */
    private String userId;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 账户状态1正常，2冻结
     */
    private String status;

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobilenum;

    /**
     * 是否是管理员 0普通用户,1管理员
     */
    private String flag;

    /**
     * 是否首次登陆：1是，0否
     */
    private String isFirstLogin;

    /**
     * 密码修改时间
     */
    private Date pwdUpdateTimestamp;

    /**
     * 用户创建时间
     */
    private Date userCreateTimestamp;

    /**
     * 密码历史
     */
    private String passwordHistory;


}