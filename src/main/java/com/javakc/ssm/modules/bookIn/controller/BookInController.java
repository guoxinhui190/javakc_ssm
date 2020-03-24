package com.javakc.ssm.modules.bookIn.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;
import com.javakc.ssm.modules.bookIn.entity.BookInEntity;
import com.javakc.ssm.modules.bookIn.service.BookInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName BookInController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:52
 * @Version 1.0
 **/
@Controller
@RequestMapping("bookIn")
public class BookInController {

    @Autowired
    BookInService bookInService;


    @RequestMapping("queryBookIn")
    public ModelAndView queryBookIn(BookInEntity bookInEntity, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("bookIn/list");
        // ##调用service中的查询方法到数据库提取数据
        Page page = bookInService.queryBookIn(bookInEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("queryNameIn")
    public ModelAndView queryNameIn(BookInEntity bookInEntity, HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView("bookIn/create");
        // ##调用service中的查询方法到数据库提取数据
        Page page = bookInService.findname(bookInEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("create")
    public String create (BookInEntity bookInEntity) {
        // ## 设置UUID
//        BookInEntity bookInEntity1 = new BookInEntity();
        bookInEntity.setBookId(CommonUtil.uuid());
        // ## 调用service中得保存方法
        bookInService.save(bookInEntity);
        return "redirect:queryBookIn.do";
    }

    @RequestMapping("view")
    public String view (String id, ModelMap modelMap) {
        // ## 调用service中得单条数据查询方法
        BookInEntity bookInEntity = bookInService.get(id);
//        BookInEntity bookInEntity = bookInService.get("bo101");
//        System.out.println(bookInEntity.toString());
//        System.out.println("------------------------------------------------");
        modelMap.put("bookInEntity",bookInEntity);
        return "bookIn/update";
    }

    @RequestMapping("update")
    public String update (BookInEntity bookInEntity) {
        // ##调用service 中的修改方法
//        BookInEntity bookInEntity1 = new BookInEntity();
//        bookInEntity1.setBookId("3e18e161dfde4e1c8743e2b5b720b41d");
//        bookInEntity1.setBookname("倚天屠龙");
        bookInService.update(bookInEntity);
        return "redirect:queryBookIn.do";
    }

    @RequestMapping("batch")
    public String delete(String[] ids) {
        // ##调用service中的批量删除方法
//        bookInService.delete(idss);
//        String[] idss = {"3e18e161dfde4e1c8743e2b5b720b41d","1"};
        bookInService.delete(ids);
        return "redirect:queryBookIn.do";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        // ##调用service中的批量删除方法
//        bookInService.signdelete(id);
        BookInEntity bookInEntity = new BookInEntity();
        bookInEntity.setBookId("1");
        bookInService.signdelete(bookInEntity);
        return "redirect:queryBookIn.do";
    }

}
