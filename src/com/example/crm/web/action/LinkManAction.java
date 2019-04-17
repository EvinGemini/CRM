package com.example.crm.web.action;

import com.example.crm.domain.Customer;
import com.example.crm.domain.LinkMan;
import com.example.crm.domain.PageBean;
import com.example.crm.service.CustomerService;
import com.example.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkMan linkMan = new LinkMan();
    private LinkManService linkManService;
    private CustomerService customerService;
    private Integer pageSize = 3;
    private Integer currentPage = 1;
    @Override
    public LinkMan getModel() {
        return linkMan;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getLkm_name() != null) {
            detachedCriteria.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));
        }
        if (linkMan.getLkm_gender() != null && !"".equals(linkMan.getLkm_gender())) {
            detachedCriteria.add(Restrictions.eq("lkm_gender",linkMan.getLkm_gender()));
        }
        PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria,pageSize,currentPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public String saveUI() {
        //查找所有客户
        List<Customer> list = customerService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "saveUI";
    }

    public String save() {
        linkManService.save(linkMan);
        return "saveSuccess";
    }

    public String edit() {
        linkMan = linkManService.findLinkManById(linkMan.getLkm_id());
        List<Customer> list = customerService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        ActionContext.getContext().getValueStack().push(linkMan);
        return "edit";
    }

    public String update() {
        linkManService.update(linkMan);
        return "updateSuccess";
    }

    public String delete() {
        linkMan = linkManService.findLinkManById(linkMan.getLkm_id());
        linkManService.delete(linkMan);
        return "deleteSuccess";
    }
}
