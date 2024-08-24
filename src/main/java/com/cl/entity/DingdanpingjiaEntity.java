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
 * 订单评价
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-18 16:40:14
 */
@TableName("dingdanpingjia")
public class DingdanpingjiaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DingdanpingjiaEntity() {
		
	}
	
	public DingdanpingjiaEntity(T t) {
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
	 * 预计送达时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yujisongdashijian;
	
	/**
	 * 完成时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date wanchengshijian;
	
	/**
	 * 评分
	 */
					
	private Integer xinyongfen;
	
	/**
	 * 评价内容
	 */
					
	private String pingjianeirong;
	
	/**
	 * 订单评价时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date dingdanpingjiashijian;
	
	/**
	 * 是准时到达
	 */
					
	private String shizhunshidaoda;
	
	/**
	 * 货物完好度
	 */
					
	private String huowuwanhaodu;
	
	
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
	 * 设置：评分
	 */
	public void setXinyongfen(Integer xinyongfen) {
		this.xinyongfen = xinyongfen;
	}
	/**
	 * 获取：评分
	 */
	public Integer getXinyongfen() {
		return xinyongfen;
	}
	/**
	 * 设置：评价内容
	 */
	public void setPingjianeirong(String pingjianeirong) {
		this.pingjianeirong = pingjianeirong;
	}
	/**
	 * 获取：评价内容
	 */
	public String getPingjianeirong() {
		return pingjianeirong;
	}
	/**
	 * 设置：订单评价时间
	 */
	public void setDingdanpingjiashijian(Date dingdanpingjiashijian) {
		this.dingdanpingjiashijian = dingdanpingjiashijian;
	}
	/**
	 * 获取：订单评价时间
	 */
	public Date getDingdanpingjiashijian() {
		return dingdanpingjiashijian;
	}
	/**
	 * 设置：是准时到达
	 */
	public void setShizhunshidaoda(String shizhunshidaoda) {
		this.shizhunshidaoda = shizhunshidaoda;
	}
	/**
	 * 获取：是准时到达
	 */
	public String getShizhunshidaoda() {
		return shizhunshidaoda;
	}
	/**
	 * 设置：货物完好度
	 */
	public void setHuowuwanhaodu(String huowuwanhaodu) {
		this.huowuwanhaodu = huowuwanhaodu;
	}
	/**
	 * 获取：货物完好度
	 */
	public String getHuowuwanhaodu() {
		return huowuwanhaodu;
	}

}
