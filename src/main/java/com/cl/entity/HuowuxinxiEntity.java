package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 货物信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("huowuxinxi")
public class HuowuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public HuowuxinxiEntity() {
		
	}
	
	public HuowuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 货物编号
	 */
					
	private String huowubianhao;
	
	/**
	 * 货物名称
	 */
					
	private String huowumingcheng;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 货物数量
	 */
					
	private Integer huowushuliang;
	
	/**
	 * 货物介绍
	 */
					
	private String huowujieshao;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 发货地址
	 */
					
	private String fahuodizhi;
	
	/**
	 * 送达地址
	 */
					
	private String songdadizhi;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
	/**
	 * 货主账号
	 */
					
	private String huozhuzhanghao;
	
	/**
	 * 货主手机
	 */
					
	private String huozhushouji;
	
	/**
	 * 货主姓名
	 */
					
	private String huozhuxingming;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 预计送达时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yujisongdashijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：货物编号
	 */
	public void setHuowubianhao(String huowubianhao) {
		this.huowubianhao = huowubianhao;
	}
	/**
	 * 获取：货物编号
	 */
	public String getHuowubianhao() {
		return huowubianhao;
	}
	/**
	 * 设置：货物名称
	 */
	public void setHuowumingcheng(String huowumingcheng) {
		this.huowumingcheng = huowumingcheng;
	}
	/**
	 * 获取：货物名称
	 */
	public String getHuowumingcheng() {
		return huowumingcheng;
	}
	/**
	 * 设置：规格
	 */
	public void setGuige(String guige) {
		this.guige = guige;
	}
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
	/**
	 * 设置：货物数量
	 */
	public void setHuowushuliang(Integer huowushuliang) {
		this.huowushuliang = huowushuliang;
	}
	/**
	 * 获取：货物数量
	 */
	public Integer getHuowushuliang() {
		return huowushuliang;
	}
	/**
	 * 设置：货物介绍
	 */
	public void setHuowujieshao(String huowujieshao) {
		this.huowujieshao = huowujieshao;
	}
	/**
	 * 获取：货物介绍
	 */
	public String getHuowujieshao() {
		return huowujieshao;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：发货地址
	 */
	public void setFahuodizhi(String fahuodizhi) {
		this.fahuodizhi = fahuodizhi;
	}
	/**
	 * 获取：发货地址
	 */
	public String getFahuodizhi() {
		return fahuodizhi;
	}
	/**
	 * 设置：送达地址
	 */
	public void setSongdadizhi(String songdadizhi) {
		this.songdadizhi = songdadizhi;
	}
	/**
	 * 获取：送达地址
	 */
	public String getSongdadizhi() {
		return songdadizhi;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
	/**
	 * 设置：货主账号
	 */
	public void setHuozhuzhanghao(String huozhuzhanghao) {
		this.huozhuzhanghao = huozhuzhanghao;
	}
	/**
	 * 获取：货主账号
	 */
	public String getHuozhuzhanghao() {
		return huozhuzhanghao;
	}
	/**
	 * 设置：货主手机
	 */
	public void setHuozhushouji(String huozhushouji) {
		this.huozhushouji = huozhushouji;
	}
	/**
	 * 获取：货主手机
	 */
	public String getHuozhushouji() {
		return huozhushouji;
	}
	/**
	 * 设置：货主姓名
	 */
	public void setHuozhuxingming(String huozhuxingming) {
		this.huozhuxingming = huozhuxingming;
	}
	/**
	 * 获取：货主姓名
	 */
	public String getHuozhuxingming() {
		return huozhuxingming;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：预计送达时间
	 */
	public void setYujisongdashijian(Date yujisongdashijian) {
		this.yujisongdashijian = yujisongdashijian;
	}
	/**
	 * 获取：预计送达时间
	 */
	public Date getYujisongdashijian() {
		return yujisongdashijian;
	}

}
