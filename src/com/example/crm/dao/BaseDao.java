package com.example.crm.dao;

import com.example.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    void save(T t);

    void delete(T t);

    void update(T t);

    T findById(Serializable id);

    Integer findCount(DetachedCriteria detachedCriteria);

    List<T> findByPage(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);

    List<T> findAll();
}
