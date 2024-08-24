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


import com.cl.dao.DingdanwanchengDao;
import com.cl.entity.DingdanwanchengEntity;
import com.cl.service.DingdanwanchengService;
import com.cl.entity.view.DingdanwanchengView;

@Service("dingdanwanchengService")
public class DingdanwanchengServiceImpl extends ServiceImpl<DingdanwanchengDao, DingdanwanchengEntity> implements DingdanwanchengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanwanchengEntity> page = this.selectPage(
                new Query<DingdanwanchengEntity>(params).getPage(),
                new EntityWrapper<DingdanwanchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanwanchengEntity> wrapper) {
		  Page<DingdanwanchengView> page =new Query<DingdanwanchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DingdanwanchengView> selectListView(Wrapper<DingdanwanchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanwanchengView selectView(Wrapper<DingdanwanchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
