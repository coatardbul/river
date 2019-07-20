package com.coatardbul.river.model.feign;

import com.coatardbul.river.model.entity.AreaItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreamFeignOutputDto {

    private List<AreaItem> list;
}
