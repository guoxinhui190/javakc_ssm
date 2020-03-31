package com.javakc.ssm.modules.customerIn.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;
import com.javakc.ssm.modules.customerIn.entity.CustomerInEntity;
import com.javakc.ssm.modules.customerIn.service.CustomerInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CustomerInController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:02
 * @Version 1.0
 **/

@Controller
@RequestMapping("customerIn")
public class CustomerInController {

    @Autowired
    CustomerInService customerInService;
    
    @RequestMapping("queryCustomerIn")
    public ModelAndView queryCustomerIn(CustomerInEntity customerInEntity, HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("customerIn/list");
        //  ##调用service中的查询方法到数据库提取数据
        Page page = customerInService.querycustomerIn(customerInEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("create")
    public String create (CustomerInEntity customerInEntity) {
        // ## 设置UUID
        // BookInEntity bookInEntity1 = new BookInEntity();
        customerInEntity.setCustomerId (CommonUtil.uuid());
        // ## 调用service中得保存方法
        customerInService.save(customerInEntity);
        return "redirect:queryCustomerIn.do";
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
        customerInService.get(ids);
        CustomerInEntity customerInEntity = customerInService.get(ids);
        modelMap.put("customerInEntity", customerInEntity);
        return "customerIn/update";

    }

    @RequestMapping("update")
    public String update(CustomerInEntity customerInEntity){
        //  ##调用service中的修改方法
        customerInService.update(customerInEntity);
        return "redirect:queryCustomerIn.do";
    }

    @RequestMapping("delete")
    public String delete(String[] ids) {
        // ##调用service中的批量删除方法
        customerInService.delete(ids);
        return "redirect:queryCustomerIn.do";
    }

}
