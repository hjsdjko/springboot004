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


import com.cl.dao.SijiDao;
import com.cl.entity.SijiEntity;
import com.cl.service.SijiService;
import com.cl.entity.view.SijiView;

@Service("sijiService")
public class SijiServiceImpl extends ServiceImpl<SijiDao, SijiEntity> implements SijiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SijiEntity> page = this.selectPage(
                new Query<SijiEntity>(params).getPage(),
                new EntityWrapper<SijiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SijiEntity> wrapper) {
		  Page<SijiView> page =new Query<SijiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<SijiView> selectListView(Wrapper<SijiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SijiView selectView(Wrapper<SijiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
