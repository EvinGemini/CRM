package com.example.crm.service.impl;

import com.example.crm.dao.LinkManDao;
import com.example.crm.domain.LinkMan;
import com.example.crm.domain.PageBean;
import com.example.crm.service.LinkManService;
import org.hibernate.criterion.DetachedCriteria;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class LinkManServiceImpl implements LinkManService {
    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }


    @Override
    public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, int pageSize, int crrentPage) {
        PageBean<LinkMan> pageBean = new PageBean<>();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(crrentPage);
        int totalCount = linkManDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        double tc = totalCount;
        Double totalPage = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(totalPage.intValue());
        int begin = (crrentPage -1) * pageSize;
        List<LinkMan> list = linkManDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }

    @Override
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    @Override
    public LinkMan findLinkManById(Long lkm_id) {
        return linkManDao.findById(lkm_id);
    }

    @Override
    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }
}
