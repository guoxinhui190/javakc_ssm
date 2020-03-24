package com.javakc.ssm.modules.chaptersOut.entity;

import com.javakc.ssm.modules.bookOut.entity.BookOutEntity;
import com.javakc.ssm.modules.operator.entity.OperatorEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ChaptersEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:59
 * @Version 1.0
 **/
@Data
public class ChaptersOutEntity {

    private String chaptersId ;
    /** 章节名称 */
    private String chaptersName ;
    /** 章节字数 */
    private Integer wordNumber ;
    /** 章节状态 */
    private String state ;
    /** 书籍id(外键) */
    private String bookId ;
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
    /** 章节序号 */
    private String chaptersNumber ;
    /** 上线时间 */
    private Date goOnlineTime ;
    /** 下线时间 */
    private Date offlineTime ;
    /** 原字数 */
    private Integer oldNumber ;
    /** 过滤词 */
    private String filterWords ;
    /** 书籍输出 **/
    private BookOutEntity bookOutEntity;
}
