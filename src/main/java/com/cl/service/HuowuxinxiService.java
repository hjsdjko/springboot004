package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuowuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuowuxinxiView;


/**
 * 货物信息
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuowuxinxiService extends IService<HuowuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuowuxinxiView> selectListView(Wrapper<HuowuxinxiEntity> wrapper);
   	
   	HuowuxinxiView selectView(@Param("ew") Wrapper<HuowuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuowuxinxiEntity> wrapper);
   	

}

