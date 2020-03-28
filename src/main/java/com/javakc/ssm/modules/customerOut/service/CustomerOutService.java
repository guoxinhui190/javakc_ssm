package com.javakc.ssm.modules.customerOut.service;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.customerOut.dao.CustomerOutDao;
import com.javakc.ssm.modules.customerOut.entity.CustomerOutEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName CustomerOutService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:05
 * @Version 1.0
 **/

@Service
public class CustomerOutService extends BaseService<CustomerOutDao, CustomerOutEntity> {

    @Autowired
    CustomerOutDao customerOutDao;

    public Page querycustomerOut(CustomerOutEntity customerOutEntity, Page page){
        //  ##设置分页参数
        customerOutEntity.setPage(page);
        //  ##调用dao方法，进行数据查询
        List<CustomerOutEntity> list = customerOutDao.findList(customerOutEntity);
        page.setList(list);
        return page;
    }


}
