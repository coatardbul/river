package com.coatardbul.river.controller;


import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.model.dto.UserDto;
import com.coatardbul.river.model.entity.UserInfo;
import com.coatardbul.river.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "用户信息")
@Slf4j
@RestController
@RequestMapping(value = "/query")
public class UserController {
    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public CommonResult insertBankAcc(@RequestBody @Valid UserDto userDto, BindingResult bindResult) {
//        UserInfo userInfo=new UserInfo();
//        userInfo.setAccount("dsf");
//        userInfo.setUserId("123123");
//        userInfoService.insert(userInfo);
//        return userInfo;
        // dto对象的非空，长度检查
        if (bindResult.hasErrors()) {
            log.error(bindResult.getFieldError().getDefaultMessage());
            return CommonResult.failed(bindResult.getFieldError().getDefaultMessage());
        }
        try {
            UserInfo userInfo = userInfoService.selectByPrimaryKey("123123");
            return CommonResult.success(userInfo);
        } catch (Exception e) {
            return CommonResult.failed(e.getMessage());
        }


    }
}
