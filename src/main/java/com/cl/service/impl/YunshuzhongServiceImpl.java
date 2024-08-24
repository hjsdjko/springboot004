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


import com.cl.dao.YunshuzhongDao;
import com.cl.entity.YunshuzhongEntity;
import com.cl.service.YunshuzhongService;
import com.cl.entity.view.YunshuzhongView;

@Service("yunshuzhongService")
public class YunshuzhongServiceImpl extends ServiceImpl<YunshuzhongDao, YunshuzhongEntity> implements YunshuzhongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YunshuzhongEntity> page = this.selectPage(
                new Query<YunshuzhongEntity>(params).getPage(),
                new EntityWrapper<YunshuzhongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YunshuzhongEntity> wrapper) {
		  Page<YunshuzhongView> page =new Query<YunshuzhongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YunshuzhongView> selectListView(Wrapper<YunshuzhongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YunshuzhongView selectView(Wrapper<YunshuzhongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
