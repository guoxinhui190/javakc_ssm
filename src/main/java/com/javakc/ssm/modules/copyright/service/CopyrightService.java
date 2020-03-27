package com.javakc.ssm.modules.copyright.service;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.copyright.dao.CopyrightDao;
import com.javakc.ssm.modules.copyright.entity.CopyrightEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CopyrightService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:01
 * @Version 1.0
 **/

@Service
public class CopyrightService extends BaseService<CopyrightDao, CopyrightEntity> {

    @Autowired
    CopyrightDao copyrightDao;

    public Page queryCopyright(CopyrightEntity copyrightEntity, Page page){
        //  ##设置分页参数
        copyrightEntity.setPage(page);
        //  ##调用dao方法，进行数据查询
        List<CopyrightEntity> list = copyrightDao.findList(copyrightEntity);
        page.setList(list);
        return page;
    }


}
