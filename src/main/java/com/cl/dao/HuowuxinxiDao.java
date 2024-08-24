package com.cl.dao;

import com.cl.entity.HuowuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowuxinxiView;


/**
 * 货物信息
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuowuxinxiDao extends BaseMapper<HuowuxinxiEntity> {
	
	List<HuowuxinxiView> selectListView(@Param("ew") Wrapper<HuowuxinxiEntity> wrapper);

	List<HuowuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<HuowuxinxiEntity> wrapper);
	
	HuowuxinxiView selectView(@Param("ew") Wrapper<HuowuxinxiEntity> wrapper);
	

}
