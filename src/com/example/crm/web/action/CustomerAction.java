package com.example.crm.web.action;

import com.example.crm.domain.Customer;
import com.example.crm.domain.PageBean;
import com.example.crm.service.CustomerService;
import com.example.crm.utils.UploadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.hibernate.criterion.DetachedCriteria;

import java.io.File;
import java.io.IOException;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private CustomerService customerService;
    private Integer currentPage = 1;
    private Integer pageSize = 3;
    private String uploadFileName;
    private File upload;
    private String uploadContentType;

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

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String saveUI() {
        return "saveUI";
    }

    public String save() throws IOException {
        if (upload != null) {
            //文件上传
            //设置文件上传路径
            String path = "F:/upload";
            String uuidFileName = UploadUtil.getUuidFileName(uploadFileName);
            //文件分离：一个目录下防止过多文件
            String subPath = UploadUtil.getPath(uuidFileName);
            String realPath = path + subPath;
            //创建目录
            File fileDir = new File(realPath);
            if (!fileDir.exists() ) {
                fileDir.mkdirs();
            }
            File destFile = new File(realPath + File.separator + uuidFileName);
            FileUtils.copyFile(upload,destFile);
            //将路径存入到数据库
            customer.setCust_image(destFile.getAbsolutePath());
        }
        customerService.save(customer);
        return "saveSuccess";
    }

    public String findAll() {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        PageBean<Customer> pageBean = customerService.findAll(detachedCriteria,currentPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }
}
