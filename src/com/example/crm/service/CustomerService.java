package com.example.crm.service;

import com.example.crm.domain.Customer;
import com.example.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    void save(Customer customer);

    PageBean<Customer> findAll(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);
}
