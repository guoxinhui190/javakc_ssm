package com.javakc.ssm.modules.system.home.dao;

import java.util.List;
import java.util.Map;

import com.javakc.ssm.base.dao.BaseDao;
import com.javakc.ssm.base.dao.MyBatisDao;
import com.javakc.ssm.modules.system.home.entity.HomeEntity;

/**
 * 首页信息模块数据层实现
 * @author javakc
 * @version 0.1
 */
@MyBatisDao
public interface HomeDao extends BaseDao<HomeEntity>{
	
	public List<Map<String, Object>> chart();
	
}
