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
import org.hibernate.criterion.Restrictions;

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
        if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
            detachedCriteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        if (customer.getBaseDictSource() != null && customer.getBaseDictSource().getDict_id() != null &&
                !"".equals(customer.getBaseDictSource().getDict_id())) {
            detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id",customer.getBaseDictSource().getDict_id()));
        }
        if (customer.getBaseDictIndustry() != null && customer.getBaseDictIndustry().getDict_id() != null &&
                !"".equals(customer.getBaseDictIndustry().getDict_id())) {
            detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id",customer.getBaseDictIndustry().getDict_id()));
        }
        if (customer.getBaseDictLevel() != null && customer.getBaseDictLevel().getDict_id() != null &&
                !"".equals(customer.getBaseDictLevel().getDict_id())) {
            detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id",customer.getBaseDictLevel().getDict_id()));
        }
        PageBean<Customer> pageBean = customerService.findAll(detachedCriteria,currentPage,pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public String delete() {
        Customer findCustomer = customerService.findCustomerById(this.customer.getCust_id());
        if (findCustomer != null) {
            if (findCustomer.getCust_image() != null && !"".equals(findCustomer.getCust_image())) {
                File file = new File(findCustomer.getCust_image());
                if (file.exists()) {
                    file.delete();
                }
            }
            customerService.delete(findCustomer);
        }
        return "deleteSuccess";
    }

    public String edit() {
        customer = customerService.findCustomerById(this.customer.getCust_id());
        //存入值栈中有两种方式
        //1.Action就在值栈中
        //2.手动压栈
        ActionContext.getContext().getValueStack().push(customer);
        return "edit";
    }

    public String update() throws IOException {
        if (upload != null) {   //上传了图片
            File file = new File(customer.getCust_image());
            if (file.exists()) {
                file.delete();
            }
            String path = "F:/upload";
            String uuidFileName = UploadUtil.getUuidFileName(uploadFileName);
            //文件目录分离
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
        customerService.update(customer);
        return "update";
    }
}
