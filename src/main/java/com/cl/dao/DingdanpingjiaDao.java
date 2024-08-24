package com.cl.dao;

import com.cl.entity.DingdanpingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanpingjiaView;


/**
 * 订单评价
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface DingdanpingjiaDao extends BaseMapper<DingdanpingjiaEntity> {
	
	List<DingdanpingjiaView> selectListView(@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);

	List<DingdanpingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);
	
	DingdanpingjiaView selectView(@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);
	

}
