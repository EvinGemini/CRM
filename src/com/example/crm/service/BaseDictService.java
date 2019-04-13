package com.example.crm.service;

import com.example.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findByTypeCode(String dict_type_code);
}
