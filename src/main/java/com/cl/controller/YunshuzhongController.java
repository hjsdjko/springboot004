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

import com.cl.entity.YunshuzhongEntity;
import com.cl.entity.view.YunshuzhongView;

import com.cl.service.YunshuzhongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 运输中
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@RestController
@RequestMapping("/yunshuzhong")
public class YunshuzhongController {
    @Autowired
    private YunshuzhongService yunshuzhongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YunshuzhongEntity yunshuzhong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			yunshuzhong.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			yunshuzhong.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YunshuzhongEntity> ew = new EntityWrapper<YunshuzhongEntity>();

		PageUtils page = yunshuzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshuzhong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YunshuzhongEntity yunshuzhong, 
		HttpServletRequest request){
        EntityWrapper<YunshuzhongEntity> ew = new EntityWrapper<YunshuzhongEntity>();

		PageUtils page = yunshuzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yunshuzhong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YunshuzhongEntity yunshuzhong){
       	EntityWrapper<YunshuzhongEntity> ew = new EntityWrapper<YunshuzhongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yunshuzhong, "yunshuzhong")); 
        return R.ok().put("data", yunshuzhongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YunshuzhongEntity yunshuzhong){
        EntityWrapper< YunshuzhongEntity> ew = new EntityWrapper< YunshuzhongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yunshuzhong, "yunshuzhong")); 
		YunshuzhongView yunshuzhongView =  yunshuzhongService.selectView(ew);
		return R.ok("查询运输中成功").put("data", yunshuzhongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YunshuzhongEntity yunshuzhong = yunshuzhongService.selectById(id);
		yunshuzhong = yunshuzhongService.selectView(new EntityWrapper<YunshuzhongEntity>().eq("id", id));
        return R.ok().put("data", yunshuzhong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YunshuzhongEntity yunshuzhong = yunshuzhongService.selectById(id);
		yunshuzhong = yunshuzhongService.selectView(new EntityWrapper<YunshuzhongEntity>().eq("id", id));
        return R.ok().put("data", yunshuzhong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YunshuzhongEntity yunshuzhong, HttpServletRequest request){
    	yunshuzhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yunshuzhong);
        yunshuzhongService.insert(yunshuzhong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YunshuzhongEntity yunshuzhong, HttpServletRequest request){
    	yunshuzhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yunshuzhong);
        yunshuzhongService.insert(yunshuzhong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YunshuzhongEntity yunshuzhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yunshuzhong);
        yunshuzhongService.updateById(yunshuzhong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yunshuzhongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
