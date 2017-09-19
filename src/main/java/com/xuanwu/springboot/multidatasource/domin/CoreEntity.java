package com.xuanwu.springboot.multidatasource.domin;

import java.util.Date;
import java.util.Map;

public class CoreEntity {
	private String id;

    /* 0-停用，1-启用 */
    private String status;

    private String name_;

    /* 创建者 */
    private String createOp;

    /* 创建者名称 */
    private String createOpName;

    /* 创建时间 */
    private Date createTime;

    /* 更新者 */
    private String updateOp;

    /* 更新者名称 */
    private String updateOpName;

    /* 更新时间 */
    private Date updateTime;

    /* 扩展字段 键(key-字段名/列名)值对 */
    /* 含有扩展map 以及 存放扩展字段的 ext(二级Map) */
    private Map<String, Object> extendParam;

    /* 备注 */
    private String remark;
    /**
     * 编辑状态，标识新增和修改
     */
    private boolean updateStatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public String getCreateOp() {
		return createOp;
	}
	public void setCreateOp(String createOp) {
		this.createOp = createOp;
	}
	public String getCreateOpName() {
		return createOpName;
	}
	public void setCreateOpName(String createOpName) {
		this.createOpName = createOpName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateOp() {
		return updateOp;
	}
	public void setUpdateOp(String updateOp) {
		this.updateOp = updateOp;
	}
	public String getUpdateOpName() {
		return updateOpName;
	}
	public void setUpdateOpName(String updateOpName) {
		this.updateOpName = updateOpName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Map<String, Object> getExtendParam() {
		return extendParam;
	}
	public void setExtendParam(Map<String, Object> extendParam) {
		this.extendParam = extendParam;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}
}
