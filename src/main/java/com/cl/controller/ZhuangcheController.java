package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZhuangcheEntity;
import com.cl.entity.view.ZhuangcheView;

import com.cl.service.ZhuangcheService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 装车
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@RestController
@RequestMapping("/zhuangche")
public class ZhuangcheController {
    @Autowired
    private ZhuangcheService zhuangcheService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuangcheEntity zhuangche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			zhuangche.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			zhuangche.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhuangcheEntity> ew = new EntityWrapper<ZhuangcheEntity>();

		PageUtils page = zhuangcheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangche), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuangcheEntity zhuangche, 
		HttpServletRequest request){
        EntityWrapper<ZhuangcheEntity> ew = new EntityWrapper<ZhuangcheEntity>();

		PageUtils page = zhuangcheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangche), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuangcheEntity zhuangche){
       	EntityWrapper<ZhuangcheEntity> ew = new EntityWrapper<ZhuangcheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuangche, "zhuangche")); 
        return R.ok().put("data", zhuangcheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuangcheEntity zhuangche){
        EntityWrapper< ZhuangcheEntity> ew = new EntityWrapper< ZhuangcheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuangche, "zhuangche")); 
		ZhuangcheView zhuangcheView =  zhuangcheService.selectView(ew);
		return R.ok("查询装车成功").put("data", zhuangcheView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuangcheEntity zhuangche = zhuangcheService.selectById(id);
		zhuangche = zhuangcheService.selectView(new EntityWrapper<ZhuangcheEntity>().eq("id", id));
        return R.ok().put("data", zhuangche);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuangcheEntity zhuangche = zhuangcheService.selectById(id);
		zhuangche = zhuangcheService.selectView(new EntityWrapper<ZhuangcheEntity>().eq("id", id));
        return R.ok().put("data", zhuangche);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuangcheEntity zhuangche, HttpServletRequest request){
    	zhuangche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuangche);
        zhuangcheService.insert(zhuangche);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuangcheEntity zhuangche, HttpServletRequest request){
    	zhuangche.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuangche);
        zhuangcheService.insert(zhuangche);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuangcheEntity zhuangche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuangche);
        zhuangcheService.updateById(zhuangche);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuangcheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
