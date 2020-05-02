package com.coatardbul.river.common.util;


import com.coatardbul.river.model.entity.BankCnaps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataCacheUtil {

    public Map<String, BankCnaps> bankCnapsMap;
}
