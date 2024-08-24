package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuozhuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuozhuView;


/**
 * 货主
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface HuozhuService extends IService<HuozhuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuozhuView> selectListView(Wrapper<HuozhuEntity> wrapper);
   	
   	HuozhuView selectView(@Param("ew") Wrapper<HuozhuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuozhuEntity> wrapper);
   	

}

