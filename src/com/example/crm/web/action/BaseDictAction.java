package com.example.crm.web.action;

import com.example.crm.domain.BaseDict;
import com.example.crm.service.BaseDictService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    private BaseDict baseDict = new BaseDict();
    private BaseDictService baseDictService;
    @Override
    public BaseDict getModel() {
        return baseDict;
    }

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    public String findByTypeCode() throws IOException {
        List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(list));
        javax.servlet.http.HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getWriter(),list);
        return NONE;
    }

}
