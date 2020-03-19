package com.javakc.ssm.modules.system.role.dao;

import java.util.Map;

import com.javakc.ssm.base.dao.BaseDao;
import com.javakc.ssm.base.dao.MyBatisDao;
import com.javakc.ssm.modules.system.role.entity.RoleEntity;

/**
 * 基础信息角色模块数据层实现
 * @author javakc
 * @version 0.1
 */
@MyBatisDao
public interface RoleDao extends BaseDao<RoleEntity>{
	
	public int insert(RoleEntity entity);
	
	public void insertRelation(Map<String, Object> data);
	
	public void deleteRelation(String roleId);
	
}
