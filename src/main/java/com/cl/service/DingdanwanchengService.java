package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanwanchengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanwanchengView;


/**
 * 订单完成
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface DingdanwanchengService extends IService<DingdanwanchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanwanchengView> selectListView(Wrapper<DingdanwanchengEntity> wrapper);
   	
   	DingdanwanchengView selectView(@Param("ew") Wrapper<DingdanwanchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanwanchengEntity> wrapper);
   	

}

