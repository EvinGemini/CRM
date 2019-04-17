package com.example.crm.service;

import com.example.crm.domain.LinkMan;
import com.example.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkManService {
    PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria,int pageSize,int crrentPage);

    void save(LinkMan linkMan);

    void update(LinkMan linkMan);

    LinkMan findLinkManById(Long lkm_id);

    void delete(LinkMan linkMan);
}