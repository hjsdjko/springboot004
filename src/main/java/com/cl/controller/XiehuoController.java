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

import com.cl.entity.XiehuoEntity;
import com.cl.entity.view.XiehuoView;

import com.cl.service.XiehuoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 卸货
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@RestController
@RequestMapping("/xiehuo")
public class XiehuoController {
    @Autowired
    private XiehuoService xiehuoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiehuoEntity xiehuo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			xiehuo.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			xiehuo.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiehuoEntity> ew = new EntityWrapper<XiehuoEntity>();

		PageUtils page = xiehuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiehuo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiehuoEntity xiehuo, 
		HttpServletRequest request){
        EntityWrapper<XiehuoEntity> ew = new EntityWrapper<XiehuoEntity>();

		PageUtils page = xiehuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiehuo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiehuoEntity xiehuo){
       	EntityWrapper<XiehuoEntity> ew = new EntityWrapper<XiehuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiehuo, "xiehuo")); 
        return R.ok().put("data", xiehuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiehuoEntity xiehuo){
        EntityWrapper< XiehuoEntity> ew = new EntityWrapper< XiehuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiehuo, "xiehuo")); 
		XiehuoView xiehuoView =  xiehuoService.selectView(ew);
		return R.ok("查询卸货成功").put("data", xiehuoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiehuoEntity xiehuo = xiehuoService.selectById(id);
		xiehuo = xiehuoService.selectView(new EntityWrapper<XiehuoEntity>().eq("id", id));
        return R.ok().put("data", xiehuo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiehuoEntity xiehuo = xiehuoService.selectById(id);
		xiehuo = xiehuoService.selectView(new EntityWrapper<XiehuoEntity>().eq("id", id));
        return R.ok().put("data", xiehuo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiehuoEntity xiehuo, HttpServletRequest request){
    	xiehuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiehuo);
        xiehuoService.insert(xiehuo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiehuoEntity xiehuo, HttpServletRequest request){
    	xiehuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiehuo);
        xiehuoService.insert(xiehuo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiehuoEntity xiehuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiehuo);
        xiehuoService.updateById(xiehuo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiehuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
