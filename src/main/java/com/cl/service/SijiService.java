package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SijiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SijiView;


/**
 * 司机
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface SijiService extends IService<SijiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SijiView> selectListView(Wrapper<SijiEntity> wrapper);
   	
   	SijiView selectView(@Param("ew") Wrapper<SijiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SijiEntity> wrapper);
   	

}

