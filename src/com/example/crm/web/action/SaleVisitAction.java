package com.example.crm.web.action;

import com.example.crm.domain.PageBean;
import com.example.crm.domain.SaleVisit;
import com.example.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.annotation.Resource;
import java.util.Date;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
    @Resource(name = "saleVisitService")
    private SaleVisitService saleVisitService;

    private SaleVisit saleVisit = new SaleVisit();

    private Integer pageSize = 3;
    private Integer currentPage = 1;
    private Date visitEndTime;

    public void setVisitEndTime(Date visitEndTime) {
        this.visitEndTime = visitEndTime;
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

    @Override
    public SaleVisit getModel() {
        return saleVisit;
    }

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
        if (saleVisit.getVisit_time() != null) {
            detachedCriteria.add(Restrictions.ge("visit_time",saleVisit.getVisit_time()));
        }
        if (visitEndTime != null) {
            detachedCriteria.add(Restrictions.le("visit_time",visitEndTime));
        }
        PageBean<SaleVisit> pageBean = saleVisitService.findAll(detachedCriteria,pageSize,currentPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public String saveUI() {
        return "saveUI";
    }

    public String save() {
        saleVisitService.save(saleVisit);
        return "saveSuccess";
    }
}
