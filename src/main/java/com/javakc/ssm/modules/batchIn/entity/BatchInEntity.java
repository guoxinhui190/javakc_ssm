package com.javakc.ssm.modules.batchIn.entity;

import com.javakc.ssm.modules.booklistIn.entity.BooklistInEntity;
import com.javakc.ssm.modules.copyright.entity.CopyrightEntity;
import com.javakc.ssm.modules.settlement.entity.SettlementEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName BatchInEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:36
 * @Version 1.0
 **/
@Data
public class BatchInEntity {

    private String batchId ;
    /** 批次名称 */
    private String bathName ;
    /** 批次书籍数量 */
    private Integer bathBooknum ;
    /** 默认运营平台 */
    private String defaultPlatform ;
    /** 授权开始时间 */
    private Date authorizationStarttime ;
    /** 授权结束时间 */
    private Date authorizationEndtime ;
    /** 分成比例 */
    private String proportion ;
    /** 逻辑删除 */
    private Integer flag ;
    /** 合作方id */
    private String copyrightid ;
    /** 合同编号 */
    private String contractNumber ;
    /** 类别 */
    private Integer partnersCategory ;
    /** 合作方 **/
    private CopyrightEntity copyrightEntity;
    /** 书单对象  **/
    private BooklistInEntity booklistInEntity;
    /** 结算管理对象 **/
    private SettlementEntity settlementEntity;
}
