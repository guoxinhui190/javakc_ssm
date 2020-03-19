package com.javakc.ssm.modules.system.menu.dao;

import java.util.List;
import java.util.Map;

import com.javakc.ssm.base.dao.BaseDao;
import com.javakc.ssm.base.dao.MyBatisDao;
import com.javakc.ssm.modules.system.menu.entity.MenuEntity;

/**
 * 基础菜单信息模块数据层实现
 * @author javakc
 * @version 0.1
 */
@MyBatisDao
public interface MenuDao extends BaseDao<MenuEntity>{
	
	public List<Map<String, Object>> findAll();
	
	public int deleteRelation(String[] id);
	
}
