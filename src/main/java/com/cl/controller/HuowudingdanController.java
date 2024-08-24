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

import com.cl.entity.HuowudingdanEntity;
import com.cl.entity.view.HuowudingdanView;

import com.cl.service.HuowudingdanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 货物订单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@RestController
@RequestMapping("/huowudingdan")
public class HuowudingdanController {
    @Autowired
    private HuowudingdanService huowudingdanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuowudingdanEntity huowudingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("huozhu")) {
			huowudingdan.setHuozhuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("siji")) {
			huowudingdan.setSijizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuowudingdanEntity> ew = new EntityWrapper<HuowudingdanEntity>();

		PageUtils page = huowudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowudingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuowudingdanEntity huowudingdan, 
		HttpServletRequest request){
        EntityWrapper<HuowudingdanEntity> ew = new EntityWrapper<HuowudingdanEntity>();

		PageUtils page = huowudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huowudingdan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuowudingdanEntity huowudingdan){
       	EntityWrapper<HuowudingdanEntity> ew = new EntityWrapper<HuowudingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huowudingdan, "huowudingdan")); 
        return R.ok().put("data", huowudingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuowudingdanEntity huowudingdan){
        EntityWrapper< HuowudingdanEntity> ew = new EntityWrapper< HuowudingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huowudingdan, "huowudingdan")); 
		HuowudingdanView huowudingdanView =  huowudingdanService.selectView(ew);
		return R.ok("查询货物订单成功").put("data", huowudingdanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuowudingdanEntity huowudingdan = huowudingdanService.selectById(id);
		huowudingdan = huowudingdanService.selectView(new EntityWrapper<HuowudingdanEntity>().eq("id", id));
        return R.ok().put("data", huowudingdan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuowudingdanEntity huowudingdan = huowudingdanService.selectById(id);
		huowudingdan = huowudingdanService.selectView(new EntityWrapper<HuowudingdanEntity>().eq("id", id));
        return R.ok().put("data", huowudingdan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuowudingdanEntity huowudingdan, HttpServletRequest request){
    	huowudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huowudingdan);
        huowudingdanService.insert(huowudingdan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuowudingdanEntity huowudingdan, HttpServletRequest request){
    	huowudingdan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huowudingdan);
        huowudingdanService.insert(huowudingdan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuowudingdanEntity huowudingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huowudingdan);
        huowudingdanService.updateById(huowudingdan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<HuowudingdanEntity> list = new ArrayList<HuowudingdanEntity>();
        for(Long id : ids) {
            HuowudingdanEntity huowudingdan = huowudingdanService.selectById(id);
            huowudingdan.setSfsh(sfsh);
            huowudingdan.setShhf(shhf);
            list.add(huowudingdan);
        }
        huowudingdanService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huowudingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
