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


import com.cl.dao.HuozhuDao;
import com.cl.entity.HuozhuEntity;
import com.cl.service.HuozhuService;
import com.cl.entity.view.HuozhuView;

@Service("huozhuService")
public class HuozhuServiceImpl extends ServiceImpl<HuozhuDao, HuozhuEntity> implements HuozhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuozhuEntity> page = this.selectPage(
                new Query<HuozhuEntity>(params).getPage(),
                new EntityWrapper<HuozhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuozhuEntity> wrapper) {
		  Page<HuozhuView> page =new Query<HuozhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuozhuView> selectListView(Wrapper<HuozhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuozhuView selectView(Wrapper<HuozhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
