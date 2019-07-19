package com.coatardbul.river.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    /**
     * 主键id
     */
    @NotBlank(message = "主键id不能为空")
    private String userId;

    /**
     * 账号
     */
    private String account;
}
