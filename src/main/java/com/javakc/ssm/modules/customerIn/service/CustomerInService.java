package com.javakc.ssm.modules.customerIn.service;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.customerIn.dao.CustomerInDao;
import com.javakc.ssm.modules.customerIn.entity.CustomerInEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName CustomerInService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:03
 * @Version 1.0
 **/

@Service
public class CustomerInService extends BaseService<CustomerInDao, CustomerInEntity> {

    @Autowired
    CustomerInDao customerInDao;

    public Page querycustomerIn(CustomerInEntity customerInEntity, Page page){
        //  ##设置分页参数
        customerInEntity.setPage(page);
        //  ##调用dao方法，进行数据查询
        List<CustomerInEntity> list = customerInDao.findList(customerInEntity);
        page.setList(list);
        return page;
    }


}
