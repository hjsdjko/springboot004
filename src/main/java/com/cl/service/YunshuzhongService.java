package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YunshuzhongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YunshuzhongView;


/**
 * 运输中
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface YunshuzhongService extends IService<YunshuzhongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YunshuzhongView> selectListView(Wrapper<YunshuzhongEntity> wrapper);
   	
   	YunshuzhongView selectView(@Param("ew") Wrapper<YunshuzhongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YunshuzhongEntity> wrapper);
   	

}

