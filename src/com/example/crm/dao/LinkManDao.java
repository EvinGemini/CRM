package com.example.crm.dao;

import com.example.crm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkManDao {
    int findCount(DetachedCriteria detachedCriteria);

    List<LinkMan> findByPage(DetachedCriteria detachedCriteria, int begin, int pageSize);
}
