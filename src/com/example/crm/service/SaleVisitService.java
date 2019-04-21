package com.example.crm.service;

import com.example.crm.domain.PageBean;
import com.example.crm.domain.SaleVisit;
import org.hibernate.criterion.DetachedCriteria;

public interface SaleVisitService {
    PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, Integer pageSize, Integer currentPage);

    void save(SaleVisit saleVisit);
}
