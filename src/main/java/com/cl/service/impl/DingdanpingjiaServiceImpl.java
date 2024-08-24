package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DingdanpingjiaDao;
import com.cl.entity.DingdanpingjiaEntity;
import com.cl.service.DingdanpingjiaService;
import com.cl.entity.view.DingdanpingjiaView;

@Service("dingdanpingjiaService")
public class DingdanpingjiaServiceImpl extends ServiceImpl<DingdanpingjiaDao, DingdanpingjiaEntity> implements DingdanpingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanpingjiaEntity> page = this.selectPage(
                new Query<DingdanpingjiaEntity>(params).getPage(),
                new EntityWrapper<DingdanpingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanpingjiaEntity> wrapper) {
		  Page<DingdanpingjiaView> page =new Query<DingdanpingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdanpingjiaView> selectListView(Wrapper<DingdanpingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanpingjiaView selectView(Wrapper<DingdanpingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
