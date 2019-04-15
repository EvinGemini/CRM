package com.example.crm.web.action;

import com.example.crm.domain.LinkMan;
import com.example.crm.domain.PageBean;
import com.example.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
    private LinkMan linkMan = new LinkMan();
    private LinkManService linkManService;
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

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria,pageSize,currentPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
