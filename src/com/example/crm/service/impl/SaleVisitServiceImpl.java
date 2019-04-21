package com.example.crm.service.impl;

import com.example.crm.dao.SaleVisitDao;
import com.example.crm.domain.PageBean;
import com.example.crm.domain.SaleVisit;
import com.example.crm.service.SaleVisitService;
import org.hibernate.criterion.DetachedCriteria;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
    @Resource(name = "saleVisitDao")
    private SaleVisitDao saleVisitDao;

    @Override
    public PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, Integer pageSize, Integer currentPage) {
        PageBean<SaleVisit> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        Integer totalCount = saleVisitDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        Double tc = totalCount.doubleValue();
        Double totalPage = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(totalPage.intValue());
        Integer begin = (currentPage -1) * pageSize;
        List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(SaleVisit saleVisit) {
        saleVisitDao.save(saleVisit);
    }
}
