package com.cl.dao;

import com.cl.entity.HuozhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuozhuView;


/**
 * 货主
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuozhuDao extends BaseMapper<HuozhuEntity> {
	
	List<HuozhuView> selectListView(@Param("ew") Wrapper<HuozhuEntity> wrapper);

	List<HuozhuView> selectListView(Pagination page,@Param("ew") Wrapper<HuozhuEntity> wrapper);
	
	HuozhuView selectView(@Param("ew") Wrapper<HuozhuEntity> wrapper);
	

}
