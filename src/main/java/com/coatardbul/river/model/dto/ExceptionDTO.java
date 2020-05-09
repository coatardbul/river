package com.coatardbul.river.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDTO {
    @NotBlank(message = "字符串不能为空")
    private String notNullStr;

    @NotBlank(message = "字符串不能为空")
    private String notBlankStr;

    @NotBlank(message = "字符串不能为空")
    private String notEmptyStr;

    private BigDecimal num;

    @NotNull(message = "字符串不能为空")
    private BigInteger notNullNum;

    @Valid
    private List list;


}
