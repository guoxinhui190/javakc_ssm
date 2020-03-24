package com.javakc.ssm.modules.category.entity;

import com.javakc.ssm.modules.bookIn.entity.BookInEntity;
import com.javakc.ssm.modules.bookOut.entity.BookOutEntity;
import lombok.Data;

/**
 * @ClassName CategoryEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/23 16:06
 * @Version 1.0
 **/
@Data
public class CategoryEntity {

    private String categoryId ;
    /** 二级分类id */
    private String twoId ;
    /** 二级分类名称 */
    private String twoName ;
    /** 一级分类 */
    private String oneId ;
    /** 一级分类名称 */
    private String oneName ;
    /** 书籍引进 **/
    private BookInEntity bookInEntity;
    /** 书籍输出 **/
    private BookOutEntity bookOutEntity;

}
