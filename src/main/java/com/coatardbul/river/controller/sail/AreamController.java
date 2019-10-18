package com.coatardbul.river.controller.sail;


import com.coatardbul.river.common.api.CommonResult;
import com.coatardbul.river.common.util.ResponseUtil;
import com.coatardbul.river.model.dto.UserDto;
import com.coatardbul.river.model.entity.AreaItem;
import com.coatardbul.river.model.feign.AreamFeignInputDto;
import com.coatardbul.river.model.feign.AreamFeignOutputDto;
import com.coatardbul.river.model.feign.RequestDto;
import com.coatardbul.river.model.feign.ResponseDto;
import com.coatardbul.river.service.AreaItemService;
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
import java.util.List;

@Api(value = "区域信息")
@Slf4j
@RestController
@RequestMapping(value = "/query")
public class AreamController {
    @Autowired
    AreaItemService areaItemService;

    @ApiOperation(value = "获取区域信息", notes = "")
    @RequestMapping(value = "/getAreamList", method = RequestMethod.POST)
    public ResponseDto getAreamInfo(@RequestBody @Valid RequestDto<AreamFeignInputDto> requestDto, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            log.error(bindResult.getFieldError().getDefaultMessage());
            return ResponseUtil.setBody(bindResult.getFieldError().getDefaultMessage());
        }
        AreamFeignInputDto body = requestDto.getBody();
        List<AreaItem> areaItem = areaItemService.selectByPrimaryKey(body.getCode(), body.getName());
        AreamFeignOutputDto areamFeignOutputDto=new AreamFeignOutputDto();
        areamFeignOutputDto.setList(areaItem);
        return  ResponseUtil.setBody(areamFeignOutputDto);
    }
}
