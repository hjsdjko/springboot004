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


import com.cl.dao.HuowudingdanDao;
import com.cl.entity.HuowudingdanEntity;
import com.cl.service.HuowudingdanService;
import com.cl.entity.view.HuowudingdanView;

@Service("huowudingdanService")
public class HuowudingdanServiceImpl extends ServiceImpl<HuowudingdanDao, HuowudingdanEntity> implements HuowudingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuowudingdanEntity> page = this.selectPage(
                new Query<HuowudingdanEntity>(params).getPage(),
                new EntityWrapper<HuowudingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuowudingdanEntity> wrapper) {
		  Page<HuowudingdanView> page =new Query<HuowudingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuowudingdanView> selectListView(Wrapper<HuowudingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuowudingdanView selectView(Wrapper<HuowudingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
