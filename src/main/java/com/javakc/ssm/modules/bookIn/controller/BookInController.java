package com.javakc.ssm.modules.bookIn.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.modules.bookIn.entity.BookInEntity;
import com.javakc.ssm.modules.bookIn.service.BookInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
