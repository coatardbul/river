package com.coatardbul.river.controller.local;


import com.coatardbul.river.common.annotation.WebLog;
import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.model.dto.UserDto;
import com.coatardbul.river.model.entity.UserInfo;
import com.coatardbul.river.service.TransactionService;
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

@Api(value = "事务")
@WebLog("1111111")
@Slf4j
@RestController
@RequestMapping(value = "/transactional")
public class TransactionalController {
    @Autowired
    TransactionService  transactionService;
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public CommonResult insertBankAcc(@RequestBody UserDto userDto, BindingResult bindResult) {


        try {
          transactionService.insertTransaction();
            return CommonResult.success(null);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return CommonResult.failed(e.getMessage());
        }


    }
}
