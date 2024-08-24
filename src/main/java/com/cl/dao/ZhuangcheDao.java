package com.cl.dao;

import com.cl.entity.ZhuangcheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuangcheView;


/**
 * 装车
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface ZhuangcheDao extends BaseMapper<ZhuangcheEntity> {
	
	List<ZhuangcheView> selectListView(@Param("ew") Wrapper<ZhuangcheEntity> wrapper);

	List<ZhuangcheView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuangcheEntity> wrapper);
	
	ZhuangcheView selectView(@Param("ew") Wrapper<ZhuangcheEntity> wrapper);
	

}
