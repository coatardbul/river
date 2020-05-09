package com.coatardbul.river.controller.local;


import com.coatardbul.river.common.constants.RequestUrlConstant;
import com.coatardbul.river.model.dto.ExceptionDTO;
import com.coatardbul.river.model.entity.BankCnaps;
import com.coatardbul.river.service.BankCnapsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Api(value = "统一异常处理")
@Slf4j
@RestController
@Validated
@ControllerAdvice
@RequestMapping(value = RequestUrlConstant.EXCEPTION_TEST)
public class ExceptionController {


    @ApiOperation(value = "参数非空的测试", notes = "")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String insertBankCnaps(@RequestBody @Valid ExceptionDTO dto, BindingResult bindingResult) {
        return null;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public String fjlksdj() {
        return "11111";
    }
    @ExceptionHandler({ Exception.class})
    public String fjlk12321sdj() {
        return "222222222";
    }
}
