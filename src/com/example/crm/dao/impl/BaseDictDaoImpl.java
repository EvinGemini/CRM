package com.example.crm.dao.impl;

import com.example.crm.dao.BaseDictDao;
import com.example.crm.domain.BaseDict;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

    @Override
    public List<BaseDict> findByTypeCode(String dict_type_code) {
        return (List<BaseDict>) getHibernateTemplate().find("from BaseDict where dict_type_code = ?0",dict_type_code);
    }
}
