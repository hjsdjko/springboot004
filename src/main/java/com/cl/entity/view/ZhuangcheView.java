package com.cl.entity.view;

import com.cl.entity.ZhuangcheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 装车
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("zhuangche")
public class ZhuangcheView  extends ZhuangcheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhuangcheView(){
	}
 
 	public ZhuangcheView(ZhuangcheEntity zhuangcheEntity){
 	try {
			BeanUtils.copyProperties(this, zhuangcheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
