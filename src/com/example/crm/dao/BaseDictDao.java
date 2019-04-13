package com.example.crm.dao;

import com.example.crm.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> findByTypeCode(String dict_type_code);
}