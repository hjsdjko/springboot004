package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuowudingdanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowudingdanView;


/**
 * 货物订单
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuowudingdanService extends IService<HuowudingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowudingdanView> selectListView(Wrapper<HuowudingdanEntity> wrapper);
   	
   	HuowudingdanView selectView(@Param("ew") Wrapper<HuowudingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowudingdanEntity> wrapper);
   	

}

