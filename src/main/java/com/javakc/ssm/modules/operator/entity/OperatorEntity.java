package com.javakc.ssm.modules.operator.entity;

import com.javakc.ssm.base.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName OperatorEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 12:10
 * @Version 1.0
 **/

@Data
public class OperatorEntity extends BaseEntity<OperatorEntity> {

    /**
     * 合作方ID
     */
    private String copyrightId;
    /**
     * 版权方名称
     */
    private String copyrightName;
    /**
     *公司名
     */
    private String companyName;
    /**
     *备注名
     */
    private String remarksName;
    /**
     *合作方类别
     * 0：输出   1：引进  2：双向
     */
    private int partnersClass;
    /**
     *逻辑删除
     * 0：未删除  1：删除
     * 默认0
     */
    private int falg;

}
