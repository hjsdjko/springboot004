package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiehuoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiehuoView;


/**
 * 卸货
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface XiehuoService extends IService<XiehuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiehuoView> selectListView(Wrapper<XiehuoEntity> wrapper);
   	
   	XiehuoView selectView(@Param("ew") Wrapper<XiehuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiehuoEntity> wrapper);
   	

}

