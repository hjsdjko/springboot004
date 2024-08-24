package com.cl.entity.view;

import com.cl.entity.HuozhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 货主
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("huozhu")
public class HuozhuView  extends HuozhuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuozhuView(){
	}
 
 	public HuozhuView(HuozhuEntity huozhuEntity){
 	try {
			BeanUtils.copyProperties(this, huozhuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
