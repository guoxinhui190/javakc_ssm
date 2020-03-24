package com.javakc.ssm.modules.batchOut.entity;

import com.javakc.ssm.modules.booklistOut.entity.BooklistOutEntity;
import com.javakc.ssm.modules.operator.entity.OperatorEntity;
import com.javakc.ssm.modules.settlement.entity.SettlementEntity;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName batchOutEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 11:49
 * @Version 1.0
 **/
@Data
public class BatchOutEntity {

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
    /** 运营方 **/
    private OperatorEntity operatorEntity;
    /** 书单对象 **/
    private BooklistOutEntity booklistOutEntity;
    /** 结算管理对象 **/
    private SettlementEntity settlementEntity;
}
