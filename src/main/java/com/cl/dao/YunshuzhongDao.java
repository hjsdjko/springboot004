package com.cl.dao;

import com.cl.entity.YunshuzhongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YunshuzhongView;


/**
 * 运输中
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface YunshuzhongDao extends BaseMapper<YunshuzhongEntity> {
	
	List<YunshuzhongView> selectListView(@Param("ew") Wrapper<YunshuzhongEntity> wrapper);

	List<YunshuzhongView> selectListView(Pagination page,@Param("ew") Wrapper<YunshuzhongEntity> wrapper);
	
	YunshuzhongView selectView(@Param("ew") Wrapper<YunshuzhongEntity> wrapper);
	

}
