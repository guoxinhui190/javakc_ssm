package com.javakc.ssm.modules.bookIn.entity;

import com.javakc.ssm.base.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BookInEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:52
 * @Version 1.0
 **/

@Data
public class BookInEntity extends BaseEntity<BookInEntity> {
    /** 书籍主键 **/
    private String bookId ;
    /** cp书籍id */
    private String cpId ;
    /** 塔读书籍id */
    private String tarotId ;
    /** 书名 */
    private String bookname ;
    /** 作者 */
    private String author ;
    /** 连载 */
    private Integer serialization ;
    /** 字数 */
    private Integer wordNumber ;
    /** 状态 */
    private Integer state ;
    /** 是否收费 */
    private Integer ifCharge ;
    /** 全本价格 */
    private Double price ;
    /** 是否原创 */
    private Integer ifOriginal ;
    /** 出版社 */
    private String press ;
    /** 出版时间 */
    private Date publishingTime ;
    /** 授权开始时间 */
    private Date rightStartTime ;
    /** 授权结束时间 */
    private Date errorEndTime ;
    /** 作者授权开始时间 */
    private Date authorRightStartTime ;
    /** 作者授权结束时间 */
    private Date authorErrorEndTime ;
    /** 接收时间 */
    private Date receivingTime ;
    /** 初审成功时间 */
    private Date oneSuccessfulTime ;
    /** 初审删除时间 */
    private Date oneDeleteTime ;
    /** 入库审核成功时间 */
    private Date inSuccessfulTime ;
    /** 入库审核删除时间 */
    private Date inDeleteTime ;
    /** 初审驳回时间 */
    private Date oneReject ;
    /** 入库审驳回时间 */
    private Date inRejectTime ;
    /** 上线时间 */
    private Date goOnlineTime ;
    /** 下线时间 */
    private Date offlineTime ;
    /** 连载更新提醒时间 */
    private Date toUpdateTime ;
    /** 授权状态 */
    private Integer authorizationStatus ;
    /** 备注 */
    private String remarks ;
    /** 逻辑删除 */
    private Integer falg ;
    /** 合作方id */
    private String copyrightid ;
    /** 书单id */
    private String booklistId ;
    /** 章节数 */
    private Integer chaptersNumber ;
    /** 分类id(外键) */
    private String categoryId ;
    /** 开始收费章节 */
    private String tollSectionStart ;

}
