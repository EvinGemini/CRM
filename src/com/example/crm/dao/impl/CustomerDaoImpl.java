package com.example.crm.dao.impl;

import com.example.crm.dao.CustomerDao;
import com.example.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Properties;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao  {

    @Override
    public void save(Customer customer) {
        getHibernateTemplate().save(customer);
    }

    @Override
    public Integer findTotalCount(DetachedCriteria detachedCriteria) {
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    public List<Customer> findAll(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<Customer>) getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }

    @Override
    public Customer findCustomerById(Long cust_id) {
        return getHibernateTemplate().get(Customer.class,cust_id);
    }

    @Override
    public void delete(Customer findCustomer) {
        getHibernateTemplate().delete(findCustomer);
    }

    @Override
    public void update(Customer customer) {
        getHibernateTemplate().update(customer);
    }
}
