package com.cl.dao;

import com.cl.entity.HuowudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowudingdanView;


/**
 * 货物订单
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuowudingdanDao extends BaseMapper<HuowudingdanEntity> {
	
	List<HuowudingdanView> selectListView(@Param("ew") Wrapper<HuowudingdanEntity> wrapper);

	List<HuowudingdanView> selectListView(Pagination page,@Param("ew") Wrapper<HuowudingdanEntity> wrapper);
	
	HuowudingdanView selectView(@Param("ew") Wrapper<HuowudingdanEntity> wrapper);
	

}
