package com.example.simple.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 城市区域 表
 * @Author Sans
 * @CreateTime 2019/9/14 15:57
 */
@Data
@TableName("rigon_city")
public class RegionCityEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	private String id;

	private String parentid;

	/**
	 * 区域中文名
	 */
	private String zhName;

	/**
	 * 区域英文名
	 */
	private String enName;

	/**
	 * 区域标题
	 */
	private String title;

	/**
	 * 区域提示
	 */
	private String sgon;

	/**
	 * 区域描述
	 */
	private String describes;

	/**
	 * 区域状态 0- 不显示 ， 1 显示
	 */
	private String statusEn;

	/**
	 * 区域类型 0 - 普通类型 1 ppt 类型
	 */
	private String type;

	/**
	 * 标题图片
	 */
	private String image;

	/**
	 * 详情图片
	 */
	private String detailimage;

	private String createTime;

	private String updateTime;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSgon() {
		return sgon;
	}

	public void setSgon(String sgon) {
		this.sgon = sgon;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	public String getStatusEn() {
		return statusEn;
	}

	public void setStatusEn(String statusEn) {
		this.statusEn = statusEn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetailimage() {
		return detailimage;
	}

	public void setDetailimage(String detailimage) {
		this.detailimage = detailimage;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}