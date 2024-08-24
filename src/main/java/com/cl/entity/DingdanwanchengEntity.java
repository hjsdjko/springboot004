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
 * 订单完成
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("dingdanwancheng")
public class DingdanwanchengEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DingdanwanchengEntity() {
		
	}
	
	public DingdanwanchengEntity(T t) {
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
					
	private String huowushuliang;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
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
	 * 司机账号
	 */
					
	private String sijizhanghao;
	
	/**
	 * 司机手机
	 */
					
	private String sijishouji;
	
	/**
	 * 司机姓名
	 */
					
	private String sijixingming;
	
	/**
	 * 车牌号
	 */
					
	private String chepaihao;
	
	/**
	 * 发货地址
	 */
					
	private String fahuodizhi;
	
	/**
	 * 送达地址
	 */
					
	private String songdadizhi;
	
	/**
	 * 预计送达时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yujisongdashijian;
	
	/**
	 * 接单日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date jiedanriqi;
	
	/**
	 * 装车时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date zhuangcheshijian;
	
	/**
	 * 开始运输时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date kaishiyunshushijian;
	
	/**
	 * 完成时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date wanchengshijian;
	
	/**
	 * 订单状态
	 */
					
	private String dingdanzhuangtai;
	
	
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
	public void setHuowushuliang(String huowushuliang) {
		this.huowushuliang = huowushuliang;
	}
	/**
	 * 获取：货物数量
	 */
	public String getHuowushuliang() {
		return huowushuliang;
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
	 * 设置：司机账号
	 */
	public void setSijizhanghao(String sijizhanghao) {
		this.sijizhanghao = sijizhanghao;
	}
	/**
	 * 获取：司机账号
	 */
	public String getSijizhanghao() {
		return sijizhanghao;
	}
	/**
	 * 设置：司机手机
	 */
	public void setSijishouji(String sijishouji) {
		this.sijishouji = sijishouji;
	}
	/**
	 * 获取：司机手机
	 */
	public String getSijishouji() {
		return sijishouji;
	}
	/**
	 * 设置：司机姓名
	 */
	public void setSijixingming(String sijixingming) {
		this.sijixingming = sijixingming;
	}
	/**
	 * 获取：司机姓名
	 */
	public String getSijixingming() {
		return sijixingming;
	}
	/**
	 * 设置：车牌号
	 */
	public void setChepaihao(String chepaihao) {
		this.chepaihao = chepaihao;
	}
	/**
	 * 获取：车牌号
	 */
	public String getChepaihao() {
		return chepaihao;
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
	/**
	 * 设置：接单日期
	 */
	public void setJiedanriqi(Date jiedanriqi) {
		this.jiedanriqi = jiedanriqi;
	}
	/**
	 * 获取：接单日期
	 */
	public Date getJiedanriqi() {
		return jiedanriqi;
	}
	/**
	 * 设置：装车时间
	 */
	public void setZhuangcheshijian(Date zhuangcheshijian) {
		this.zhuangcheshijian = zhuangcheshijian;
	}
	/**
	 * 获取：装车时间
	 */
	public Date getZhuangcheshijian() {
		return zhuangcheshijian;
	}
	/**
	 * 设置：开始运输时间
	 */
	public void setKaishiyunshushijian(Date kaishiyunshushijian) {
		this.kaishiyunshushijian = kaishiyunshushijian;
	}
	/**
	 * 获取：开始运输时间
	 */
	public Date getKaishiyunshushijian() {
		return kaishiyunshushijian;
	}
	/**
	 * 设置：完成时间
	 */
	public void setWanchengshijian(Date wanchengshijian) {
		this.wanchengshijian = wanchengshijian;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getWanchengshijian() {
		return wanchengshijian;
	}
	/**
	 * 设置：订单状态
	 */
	public void setDingdanzhuangtai(String dingdanzhuangtai) {
		this.dingdanzhuangtai = dingdanzhuangtai;
	}
	/**
	 * 获取：订单状态
	 */
	public String getDingdanzhuangtai() {
		return dingdanzhuangtai;
	}

}
