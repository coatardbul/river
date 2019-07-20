package com.coatardbul.river.model.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreamFeignInputDto {
    /**
     * 地区名称主键
     */
    private String code;

    /**
     * 地区名称主键
     */
    private String name;
}
