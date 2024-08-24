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


import com.cl.dao.HuowuxinxiDao;
import com.cl.entity.HuowuxinxiEntity;
import com.cl.service.HuowuxinxiService;
import com.cl.entity.view.HuowuxinxiView;

@Service("huowuxinxiService")
public class HuowuxinxiServiceImpl extends ServiceImpl<HuowuxinxiDao, HuowuxinxiEntity> implements HuowuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowuxinxiEntity> page = this.selectPage(
                new Query<HuowuxinxiEntity>(params).getPage(),
                new EntityWrapper<HuowuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowuxinxiEntity> wrapper) {
		  Page<HuowuxinxiView> page =new Query<HuowuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuowuxinxiView> selectListView(Wrapper<HuowuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowuxinxiView selectView(Wrapper<HuowuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
