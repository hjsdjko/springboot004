package com.cl.entity.view;

import com.cl.entity.YunshuzhongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 运输中
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("yunshuzhong")
public class YunshuzhongView  extends YunshuzhongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YunshuzhongView(){
	}
 
 	public YunshuzhongView(YunshuzhongEntity yunshuzhongEntity){
 	try {
			BeanUtils.copyProperties(this, yunshuzhongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
