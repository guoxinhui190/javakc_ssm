package com.javakc.ssm.modules.customerIn.entity;

import com.javakc.ssm.base.entity.BaseEntity;
import com.javakc.ssm.modules.copyright.entity.CopyrightEntity;
import lombok.Data;
import java.util.Date;

/**
 * @ClassName CustomerInEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:03
 * @Version 1.0
 **/

@Data
public class CustomerInEntity extends BaseEntity<CustomerInEntity> {

    /**
     * 客户ID
     */
    private String customerId;
    /**
     *合作方ID
     */
    private String copyrightId;
    /**
     *客户姓名
     */
    private String customerName;
    /**
     *性别
     * 1：男  2：女
     */
    private int sex;
    /**
     *出生日期
     */
    private Date birthday;
    /**
     *职务
     */
    private String post;
    /**
     *手机号
     */
    private String phoneNumber;
    /**
     *座机号
     */
    private String landlineNumber;
    /**
     *邮箱
     */
    private String mailbox;
    /**
     *QQ号
     */
    private String QQ;
    /**
     *公司地址
     */
    private String companyAddress;
    /**
     *备注
     */
    private String remarks;
    /**
     *逻辑删除
     * 0：未删除  1：删除
     * 默认0
     */
    private int falg;

}
