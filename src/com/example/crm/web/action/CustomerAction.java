package com.example.crm.web.action;

import com.example.crm.domain.Customer;
import com.example.crm.domain.PageBean;
import com.example.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage = 1;
    private Integer pageSize = 3;

    @Override
    public Customer getModel() {
        return customer;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }
    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    public String saveUI() {
        return "saveUI";
    }

    public String save() {
        customerService.save(customer);
        return NONE;
    }

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        PageBean<Customer> pageBean = customerService.findAll(detachedCriteria,currentPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
