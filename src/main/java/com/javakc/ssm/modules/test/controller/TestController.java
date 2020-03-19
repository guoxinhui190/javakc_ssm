package com.javakc.ssm.modules.test.controller;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.util.CommonUtil;
import com.javakc.ssm.modules.test.entity.TestEntity;
import com.javakc.ssm.modules.test.servie.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/16 16:21
 * @Version 1.0
 **/
@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService  testService;

   /**
     * 根据条件进行分页查询测试信息数据
     * @Date 16:52 2020/3/16
     * @Param [testEntity, request, response]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("queryTest")
    public ModelAndView queryTest(TestEntity testEntity, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("test/list");
        //调用service中的查询方法到数据库提取数据
            Page page = testService.queryTest(testEntity,new Page(request,response));
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    @RequestMapping("create")
    public String create (TestEntity testEntity) {
        // ## 设置UUID
        testEntity.setTestId(CommonUtil.uuid());
        // ## 调用service中得保存方法
        testService.save(testEntity);
        return "redirect:queryTest.do";
    }

    @RequestMapping("view")
    public String view (String ids, ModelMap modelMap) {
        // ## 调用service中得单条数据查询方法
        TestEntity testEntity = testService.get(ids);
        modelMap.put("testEntity",testEntity);
        return "test/update";
    }

    @RequestMapping("update")
    public String update (TestEntity testEntity) {
        // ##调用service 中的修改方法
        testService.update(testEntity);
        return "redirect:queryTest.do";
    }

    @RequestMapping("delete")
    public String delete(String[] ids) {
        // ##调用service中的批量删除方法
        testService.delete(ids);
        return "redirect:queryTest.do";
    }

}
