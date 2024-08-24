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


import com.cl.dao.ZhuangcheDao;
import com.cl.entity.ZhuangcheEntity;
import com.cl.service.ZhuangcheService;
import com.cl.entity.view.ZhuangcheView;

@Service("zhuangcheService")
public class ZhuangcheServiceImpl extends ServiceImpl<ZhuangcheDao, ZhuangcheEntity> implements ZhuangcheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangcheEntity> page = this.selectPage(
                new Query<ZhuangcheEntity>(params).getPage(),
                new EntityWrapper<ZhuangcheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangcheEntity> wrapper) {
		  Page<ZhuangcheView> page =new Query<ZhuangcheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhuangcheView> selectListView(Wrapper<ZhuangcheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangcheView selectView(Wrapper<ZhuangcheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
