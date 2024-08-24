package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DingdanpingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DingdanpingjiaView;


/**
 * 订单评价
 *
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
public interface DingdanpingjiaService extends IService<DingdanpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanpingjiaView> selectListView(Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	DingdanpingjiaView selectView(@Param("ew") Wrapper<DingdanpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanpingjiaEntity> wrapper);
   	

}

