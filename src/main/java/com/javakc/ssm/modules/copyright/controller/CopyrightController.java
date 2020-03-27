package com.javakc.ssm.modules.copyright.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;
import com.javakc.ssm.modules.bookIn.entity.BookInEntity;
import com.javakc.ssm.modules.copyright.entity.CopyrightEntity;
import com.javakc.ssm.modules.copyright.service.CopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CopyrightController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("copyright")
public class CopyrightController {

    @Autowired
    CopyrightService copyrightService;


    @RequestMapping("queryCopyright")
    public ModelAndView queryCopyright(CopyrightEntity copyrightEntity, HttpServletRequest request, HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("copyright/list");
        //  ##调用service中的查询方法到数据库提取数据
        Page page = copyrightService.queryCopyright(copyrightEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

//    @RequestMapping("create")
//    public String create (CopyrightEntity copyrightEntity) {
//        // ## 设置UUID
//        // BookInEntity bookInEntity1 = new BookInEntity();
//        copyrightEntity.setCopyrightId (CommonUtil.uuid());
//        // ## 调用service中得保存方法
//        copyrightService.save(copyrightEntity);
//        return "redirect:copyright.do";
//    }
//
//    /**
//     * 测试管理——根据选中的测试数据的ID进行查询
//     * @param ids
//     * @param modelMap
//     * @return
//     */
//    @RequestMapping("view")
//    public String view(String ids, ModelMap modelMap){
//        //  ##调用service中的单条数据查询方法
//        copyrightService.get(ids);
//        CopyrightEntity copyrightEntity = copyrightService.get(ids);
//        modelMap.put("copyrightEntity", copyrightEntity);
//        return "copyright/update";
//
//    }
//
//    @RequestMapping("update")
//    public String update(CopyrightEntity copyrightEntity){
//        //  ##调用service中的修改方法
//        copyrightService.update(copyrightEntity);
//        return "redirect:copyright.do";
//    }
//
//    @RequestMapping("delete")
//    public String delete(String[] ids) {
//        // ##调用service中的批量删除方法
//        copyrightService.delete(ids);
//        return "redirect:copyright.do";
//    }


}
