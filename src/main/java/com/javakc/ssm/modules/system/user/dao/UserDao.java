package com.javakc.ssm.modules.system.user.dao;

import com.javakc.ssm.base.dao.BaseDao;
import com.javakc.ssm.base.dao.MyBatisDao;
import com.javakc.ssm.modules.system.user.entity.UserEntity;

import java.util.Map;

/**
 * 基础用户信息模块数据层实现
 * @author javakc
 * @version 0.1
 */
@MyBatisDao
public interface UserDao extends BaseDao<UserEntity>{
	
	public int insert(UserEntity entity);
	
	public void insertRelation(Map<String, Object> data);
	
	public void deleteRelation(String userId);
	
	public String login(String loginName);
	
	public UserEntity findByName(String loginName);

}
