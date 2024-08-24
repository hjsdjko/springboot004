package com.cl.dao;

import com.cl.entity.SijiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SijiView;


/**
 * 司机
 * 
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface SijiDao extends BaseMapper<SijiEntity> {
	
	List<SijiView> selectListView(@Param("ew") Wrapper<SijiEntity> wrapper);

	List<SijiView> selectListView(Pagination page,@Param("ew") Wrapper<SijiEntity> wrapper);
	
	SijiView selectView(@Param("ew") Wrapper<SijiEntity> wrapper);
	

}
