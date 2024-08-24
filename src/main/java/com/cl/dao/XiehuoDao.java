package com.cl.dao;

import com.cl.entity.XiehuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiehuoView;


/**
 * 卸货
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface XiehuoDao extends BaseMapper<XiehuoEntity> {
	
	List<XiehuoView> selectListView(@Param("ew") Wrapper<XiehuoEntity> wrapper);

	List<XiehuoView> selectListView(Pagination page,@Param("ew") Wrapper<XiehuoEntity> wrapper);
	
	XiehuoView selectView(@Param("ew") Wrapper<XiehuoEntity> wrapper);
	

}
