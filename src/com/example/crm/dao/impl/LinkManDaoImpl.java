package com.example.crm.dao.impl;

import com.example.crm.dao.LinkManDao;
import com.example.crm.domain.LinkMan;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

    @Override
    public int findCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, int begin, int pageSize) {
        detachedCriteria.setProjection(null);
        List<LinkMan> list = (List<LinkMan>) getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(LinkMan linkMan) {
        getHibernateTemplate().save(linkMan);
    }

    @Override
    public void update(LinkMan linkMan) {
        getHibernateTemplate().update(linkMan);
    }

    @Override
    public LinkMan findLinkManById(Long lkm_id) {
        return getHibernateTemplate().get(LinkMan.class,lkm_id);
    }

    @Override
    public void delete(LinkMan linkMan) {
        getHibernateTemplate().delete(linkMan);
    }


}
