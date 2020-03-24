package com.javakc.ssm.modules.bookIn.dao;

import com.javakc.ssm.base.dao.BaseDao;
import com.javakc.ssm.modules.bookIn.entity.BookInEntity;

import java.util.List;

/**
 * @InterfaceName BookInDao
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:52
 * @Version 1.0
 **/
public interface BookInDao extends BaseDao<BookInEntity> {

    public int signdelete(BookInEntity bookInEntity);
    public List findCopyRightname(BookInEntity bookInEntity);
    public List findBatchname(BookInEntity bookInEntity);
    public List findBooklistname(BookInEntity bookInEntity);
}
