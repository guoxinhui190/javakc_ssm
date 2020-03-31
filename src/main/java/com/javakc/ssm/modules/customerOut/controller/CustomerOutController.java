package com.javakc.ssm.modules.customerOut.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;
import com.javakc.ssm.modules.customerOut.entity.CustomerOutEntity;
import com.javakc.ssm.modules.customerOut.service.CustomerOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomerOutController
 * @Description TODO
 * @Author AdmOutistrator
 * @Date 2020/3/21 12:02
 * @Version 1.0
 **/

@Controller
@RequestMapping("customerOut")
public class CustomerOutController {

    @Autowired
    CustomerOutService customerOutService;

    @RequestMapping("queryCustomerOut")
    public ModelAndView queryCustomerOut(CustomerOutEntity customerOutEntity, HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("customerOut/list");
        //  ##调用service中的查询方法到数据库提取数据
        Page page = customerOutService.querycustomerOut(customerOutEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("create")
    public String create (CustomerOutEntity customerOutEntity) {
        // ## 设置UUID
        // BookOutEntity bookOutEntity1 = new BookOutEntity();
        customerOutEntity.setCustomerId (CommonUtil.uuid());
        // ## 调用service中得保存方法
        customerOutService.save(customerOutEntity);
        return "redirect:queryCustomerOut.do";
    }

    /**
     * 测试管理——根据选中的测试数据的ID进行查询
     * @param ids
     * @param modelMap
     * @return
     */
    @RequestMapping("view")
    public String view(String ids, ModelMap modelMap){
        //  ##调用service中的单条数据查询方法
        customerOutService.get(ids);
        CustomerOutEntity customerOutEntity = customerOutService.get(ids);
        modelMap.put("customerOutEntity", customerOutEntity);
        return "customerOut/update";

    }

    @RequestMapping("update")
    public String update(CustomerOutEntity customerOutEntity){
        //  ##调用service中的修改方法
        customerOutService.update(customerOutEntity);
        return "redirect:queryCustomerOut.do";
    }

    @RequestMapping("delete")
    public String delete(String[] ids) {
        // ##调用service中的批量删除方法
        customerOutService.delete(ids);
        return "redirect:queryCustomerOut.do";
    }

}
