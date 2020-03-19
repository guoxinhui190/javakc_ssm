package com.javakc.ssm.modules.test.entity;

import com.javakc.ssm.base.entity.BaseEntity;
import lombok.Data;

import java.util.Date;
/**
 * @ClassName TestEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/16 16:22
 * @Version 1.0
 **/
@Data
public class TestEntity extends BaseEntity<TestEntity> {

    private String testId;
    private String testName;
    private String testSex;
    private Date testDate;
}
