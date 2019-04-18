package com.example.crm.service.impl;

import com.example.crm.dao.CustomerDao;
import com.example.crm.domain.Customer;
import com.example.crm.domain.PageBean;
import com.example.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public PageBean<Customer> findAll(DetachedCriteria detachedCriteria, Integer currentPage, Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        Integer totalCount = customerDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        Double tc = totalCount.doubleValue();
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        Integer begin = (currentPage - 1) * pageSize;
        List<Customer> customerList = customerDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(customerList);
        return pageBean;
    }

    @Override
    public Customer findCustomerById(Long cust_id) {
        return customerDao.findById(cust_id);
    }

    @Override
    public void delete(Customer findCustomer) {
        customerDao.delete(findCustomer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
