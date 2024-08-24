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

import com.cl.entity.HuozhuEntity;
import com.cl.entity.view.HuozhuView;

import com.cl.service.HuozhuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 货主
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@RestController
@RequestMapping("/huozhu")
public class HuozhuController {
    @Autowired
    private HuozhuService huozhuService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuozhuEntity u = huozhuService.selectOne(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"huozhu",  "货主" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuozhuEntity huozhu){
    	//ValidatorUtils.validateEntity(huozhu);
    	HuozhuEntity u = huozhuService.selectOne(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huozhu.setId(uId);
        huozhuService.insert(huozhu);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuozhuEntity u = huozhuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuozhuEntity u = huozhuService.selectOne(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        huozhuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuozhuEntity huozhu,
		HttpServletRequest request){
        EntityWrapper<HuozhuEntity> ew = new EntityWrapper<HuozhuEntity>();

		PageUtils page = huozhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huozhu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuozhuEntity huozhu, 
		HttpServletRequest request){
        EntityWrapper<HuozhuEntity> ew = new EntityWrapper<HuozhuEntity>();

		PageUtils page = huozhuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huozhu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuozhuEntity huozhu){
       	EntityWrapper<HuozhuEntity> ew = new EntityWrapper<HuozhuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huozhu, "huozhu")); 
        return R.ok().put("data", huozhuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuozhuEntity huozhu){
        EntityWrapper< HuozhuEntity> ew = new EntityWrapper< HuozhuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huozhu, "huozhu")); 
		HuozhuView huozhuView =  huozhuService.selectView(ew);
		return R.ok("查询货主成功").put("data", huozhuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuozhuEntity huozhu = huozhuService.selectById(id);
		huozhu = huozhuService.selectView(new EntityWrapper<HuozhuEntity>().eq("id", id));
        return R.ok().put("data", huozhu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuozhuEntity huozhu = huozhuService.selectById(id);
		huozhu = huozhuService.selectView(new EntityWrapper<HuozhuEntity>().eq("id", id));
        return R.ok().put("data", huozhu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        if(huozhuService.selectCount(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
    	huozhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huozhu);
    	HuozhuEntity u = huozhuService.selectOne(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huozhu.setId(new Date().getTime());
        huozhuService.insert(huozhu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        if(huozhuService.selectCount(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()))>0) {
            return R.error("货主账号已存在");
        }
    	huozhu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huozhu);
    	HuozhuEntity u = huozhuService.selectOne(new EntityWrapper<HuozhuEntity>().eq("huozhuzhanghao", huozhu.getHuozhuzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huozhu.setId(new Date().getTime());
        huozhuService.insert(huozhu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuozhuEntity huozhu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huozhu);
        huozhuService.updateById(huozhu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<HuozhuEntity> list = new ArrayList<HuozhuEntity>();
        for(Long id : ids) {
            HuozhuEntity huozhu = huozhuService.selectById(id);
            huozhu.setSfsh(sfsh);
            huozhu.setShhf(shhf);
            list.add(huozhu);
        }
        huozhuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huozhuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
