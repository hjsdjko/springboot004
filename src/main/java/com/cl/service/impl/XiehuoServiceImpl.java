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


import com.cl.dao.XiehuoDao;
import com.cl.entity.XiehuoEntity;
import com.cl.service.XiehuoService;
import com.cl.entity.view.XiehuoView;

@Service("xiehuoService")
public class XiehuoServiceImpl extends ServiceImpl<XiehuoDao, XiehuoEntity> implements XiehuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiehuoEntity> page = this.selectPage(
                new Query<XiehuoEntity>(params).getPage(),
                new EntityWrapper<XiehuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiehuoEntity> wrapper) {
		  Page<XiehuoView> page =new Query<XiehuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiehuoView> selectListView(Wrapper<XiehuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiehuoView selectView(Wrapper<XiehuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
