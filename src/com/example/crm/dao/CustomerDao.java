package com.example.crm.dao;

import com.example.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {

    void save(Customer customer);

    Integer findTotalCount(DetachedCriteria detachedCriteria);

    List<Customer> findAll(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

    Customer findCustomerById(Long cust_id);

    void delete(Customer findCustomer);

    void update(Customer customer);

    List<Customer> findAll();
}
