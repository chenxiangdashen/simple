package com.example.simple.entity;

import javax.persistence.*;

@Table(name = "rigon_city")
public class RigonCity {
    @Id
    private String id;

    @Column(name = "parentId")
    private String parentid;

    /**
     * 区域中文名
     */
    @Column(name = "zh_name")
    private String zhName;

    /**
     * 区域英文名
     */
    @Column(name = "en_name")
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
    @Column(name = "status_en")
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
    @Column(name = "detailImage")
    private String detailimage;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return parentId
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    /**
     * 获取区域中文名
     *
     * @return zh_name - 区域中文名
     */
    public String getZhName() {
        return zhName;
    }

    /**
     * 设置区域中文名
     *
     * @param zhName 区域中文名
     */
    public void setZhName(String zhName) {
        this.zhName = zhName == null ? null : zhName.trim();
    }

    /**
     * 获取区域英文名
     *
     * @return en_name - 区域英文名
     */
    public String getEnName() {
        return enName;
    }

    /**
     * 设置区域英文名
     *
     * @param enName 区域英文名
     */
    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    /**
     * 获取区域标题
     *
     * @return title - 区域标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置区域标题
     *
     * @param title 区域标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取区域提示
     *
     * @return sgon - 区域提示
     */
    public String getSgon() {
        return sgon;
    }

    /**
     * 设置区域提示
     *
     * @param sgon 区域提示
     */
    public void setSgon(String sgon) {
        this.sgon = sgon == null ? null : sgon.trim();
    }

    /**
     * 获取区域描述
     *
     * @return describes - 区域描述
     */
    public String getDescribes() {
        return describes;
    }

    /**
     * 设置区域描述
     *
     * @param describes 区域描述
     */
    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    /**
     * 获取区域状态 0- 不显示 ， 1 显示
     *
     * @return status_en - 区域状态 0- 不显示 ， 1 显示
     */
    public String getStatusEn() {
        return statusEn;
    }

    /**
     * 设置区域状态 0- 不显示 ， 1 显示
     *
     * @param statusEn 区域状态 0- 不显示 ， 1 显示
     */
    public void setStatusEn(String statusEn) {
        this.statusEn = statusEn == null ? null : statusEn.trim();
    }

    /**
     * 获取区域类型 0 - 普通类型 1 ppt 类型 
     *
     * @return type - 区域类型 0 - 普通类型 1 ppt 类型 
     */
    public String getType() {
        return type;
    }

    /**
     * 设置区域类型 0 - 普通类型 1 ppt 类型 
     *
     * @param type 区域类型 0 - 普通类型 1 ppt 类型 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取标题图片
     *
     * @return image - 标题图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置标题图片
     *
     * @param image 标题图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 获取详情图片
     *
     * @return detailImage - 详情图片
     */
    public String getDetailimage() {
        return detailimage;
    }

    /**
     * 设置详情图片
     *
     * @param detailimage 详情图片
     */
    public void setDetailimage(String detailimage) {
        this.detailimage = detailimage == null ? null : detailimage.trim();
    }

    /**
     * @return create_time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * @return update_time
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}