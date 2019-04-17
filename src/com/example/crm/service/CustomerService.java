package com.example.crm.service;

import com.example.crm.domain.Customer;
import com.example.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    PageBean<Customer> findAll(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize);

    Customer findCustomerById(Long cust_id);

    void delete(Customer findCustomer);

    void update(Customer customer);

    List<Customer> findAll();
}
