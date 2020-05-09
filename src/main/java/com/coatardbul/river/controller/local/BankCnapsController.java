package com.coatardbul.river.controller.local;


import com.coatardbul.river.common.annotation.WebLog;
import com.coatardbul.river.common.constants.RequestUrlConstant;
import com.coatardbul.river.model.entity.BankCnaps;
import com.coatardbul.river.service.BankCnapsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "人行联行号")
@Slf4j
@WebLog
@RestController
@ControllerAdvice
@RequestMapping(value = RequestUrlConstant.BANK_CNAPS)
public class BankCnapsController {
    @Autowired
    BankCnapsService bankCnapsService;

    /**
     * 解析本地的zip文件，将文件中的数据插入到表中
     *
     */
    @ApiOperation(value = "解析本地的zip文件", notes = "")
    @RequestMapping(value = "/parseFile", method = RequestMethod.POST)
    public void parseFile() {
        bankCnapsService.parseFile();
    }

    @ApiOperation(value = "新增人行联行号数据", notes = "")
    @RequestMapping(value = "/insertBankCnaps", method = RequestMethod.POST)
    public void insertBankCnaps(@RequestBody @Valid BankCnaps dto, BindingResult bindingResult) {
        bankCnapsService.insertSelective(dto);
    }
    @ApiOperation(value = "删除人行联行号数据", notes = "")
    @RequestMapping(value = "/deleteByBankCode", method = RequestMethod.POST)
    public void deleteByBankCode(@RequestBody @Valid BankCnaps dto, BindingResult bindingResult) {
        bankCnapsService.deleteByPrimaryKey(dto.getCnapsCode());
    }
    @ApiOperation(value = "更新人行联行号数据", notes = "")
    @RequestMapping(value = "/updateBankCnaps", method = RequestMethod.POST)
    public void updateBankCnaps(@RequestBody @Valid BankCnaps dto, BindingResult bindingResult) {
        bankCnapsService.updateByPrimaryKeySelective(dto);
    }

}
