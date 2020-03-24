package com.javakc.ssm.modules.bookIn.service;

import com.javakc.ssm.base.page.Page;
import com.javakc.ssm.base.service.BaseService;
import com.javakc.ssm.modules.bookIn.dao.BookInDao;
import com.javakc.ssm.modules.bookIn.entity.BookInEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookInService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:53
 * @Version 1.0
 **/
@Service
public class BookInService extends BaseService<BookInDao, BookInEntity> {

    @Autowired
    BookInDao bookInDao;

    public Page queryBookIn(BookInEntity bookInEntity, Page page)
    {
        // ##设置分页参数
        bookInEntity.setPage(page);
        // ##调用dao方法,进行数据查询
//        BookInEntity bookInEntity1 = new BookInEntity();
//        bookInEntity1.setCopyrightid("1");
//        List<BookInEntity> list = bookInDao.findList(bookInEntity1);
        List<BookInEntity> list = bookInDao.findList(bookInEntity);
        page.setList(list);
        System.out.println(list.toString());
        return page;
    }


    public Page findname(BookInEntity bookInEntity, Page page)
    {
        bookInEntity.setPage(page);
        List<BookInEntity> Copyrightlist = bookInDao.findCopyRightname(bookInEntity);
        List<BookInEntity> Batchlist = bookInDao.findBatchname(bookInEntity);
        List<BookInEntity> Booklistlist = bookInDao.findBooklistname(bookInEntity);
        List list = new ArrayList();
        list.add(Copyrightlist);
        list.add(Batchlist);
        list.add(Booklistlist);
        page.setList(list);
        System.out.println(list.toString());
        return page;
    }

    @Transactional(readOnly = false)
    public void signdelete(BookInEntity bookInEntity) {
        bookInDao.signdelete(bookInEntity);
    }


}
