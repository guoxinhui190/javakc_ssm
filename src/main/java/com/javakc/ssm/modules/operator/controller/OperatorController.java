package com.javakc.ssm.modules.operator.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;


import com.javakc.ssm.modules.operator.entity.OperatorEntity;
import com.javakc.ssm.modules.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName OperatorController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:09
 * @Version 1.0
 **/
public class OperatorController {


    @Autowired
    OperatorService operatorService;


    @RequestMapping("queryOperator")
    public ModelAndView queryOperator(OperatorEntity operatorEntity, HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("operator/list");
        //  ##调用service中的查询方法到数据库提取数据
        Page page = operatorService.queryOperator(operatorEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("create")
    public String create (OperatorEntity operatorEntity) {
        // ## 设置UUID
        // BookInEntity bookInEntity1 = new BookInEntity();
        operatorEntity.setCopyrightId (CommonUtil.uuid());
        // ## 调用service中得保存方法
        operatorService.save(operatorEntity);
        return "redirect:queryOperator.do";
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
        operatorService.get(ids);
        OperatorEntity operatorEntity = operatorService.get(ids);
        modelMap.put("operatorEntity", operatorEntity);
        return "operator/update";

    }

    @RequestMapping("update")
    public String update(OperatorEntity operatorEntity){
        //  ##调用service中的修改方法
        operatorService.update(operatorEntity);
        return "redirect:queryOperator.do";
    }

    @RequestMapping("delete")
    public String delete(String[] ids) {
        // ##调用service中的批量删除方法
        operatorService.delete(ids);
        return "redirect:queryOperator.do";
    }
    
}
