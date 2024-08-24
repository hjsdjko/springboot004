package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhuangcheEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuangcheView;


/**
 * 装车
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface ZhuangcheService extends IService<ZhuangcheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuangcheView> selectListView(Wrapper<ZhuangcheEntity> wrapper);
   	
   	ZhuangcheView selectView(@Param("ew") Wrapper<ZhuangcheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuangcheEntity> wrapper);
   	

}

