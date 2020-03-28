package com.javakc.ssm.modules.operator.service;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.operator.dao.OperatorDao;
import com.javakc.ssm.modules.operator.entity.OperatorEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName OperatorService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:10
 * @Version 1.0
 **/
public class OperatorService extends BaseService<OperatorDao, OperatorEntity> {

    @Autowired
    OperatorDao operatorDao;

    public Page queryOperator(OperatorEntity operatorEntity, Page page){
        //  ##设置分页参数
        operatorEntity.setPage(page);
        //  ##调用dao方法，进行数据查询
        List<OperatorEntity> list = operatorDao.findList(operatorEntity);
        page.setList(list);
        return page;
    }

}
