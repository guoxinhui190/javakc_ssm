package com.javakc.ssm.modules.test.servie;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.test.dao.TestDao;
import com.javakc.ssm.modules.test.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/16 16:21
 * @Version 1.0
 **/
@Service
public class TestService extends BaseService<TestDao, TestEntity> {

    @Autowired
    TestDao testDao;

    /**
     * 根据条件进行分页查询
     * @Date 16:59 2020/3/16
     * @Param [testEntity, page]
     * @return com.javakc.ssm.base.page.Page
     **/
    public Page queryTest(TestEntity testEntity,Page page) {
        // ##设置分页参数
        testEntity.setPage(page);
        // ##调用dao方法，进行数据查询
        List<TestEntity> list =  testDao.findList(testEntity);
        page.setList(list);
        return page;
    }
}
