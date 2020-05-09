package com.coatardbul.river.controller.local;


import com.coatardbul.river.common.annotation.WebLog;
import com.coatardbul.river.common.constants.RequestUrlConstant;
import com.coatardbul.river.model.dto.ExceptionParameterDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Api(value = "统一异常处理")
@Slf4j
@RestController
@Validated
@WebLog
@RequestMapping(value = RequestUrlConstant.EXCEPTION_TEST)
public class ExceptionController {


    @ApiOperation(value = "参数非空的测试", notes = "")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String insertBankCnaps(@RequestBody @Valid ExceptionParameterDTO dto, BindingResult bindingResult) {
        return null;
    }


}
