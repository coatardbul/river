package com.coatardbul.river.service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

public interface CommonService<T> {


    /**
     * 将List转换成map
     *
     * @param key
     * @param list
     * @return
     * @throws IllegalAccessException
     */
    public Map<String, T> convertListToMap(@NotBlank String key, List<T> list) throws IllegalAccessException ;


}
