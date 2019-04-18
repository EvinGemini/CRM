package com.example.crm.dao.impl;

import com.example.crm.dao.CustomerDao;
import com.example.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
import java.util.Properties;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao  {

}
