package indi.zzw.api.apply;

import java.time.LocalDateTime;

public class Apply {
	//主键
	private String id;
	//申请人ID
	private String applyId;
	//申请人身份证号码
	private String applyCardId;
	//申请时间
	private LocalDateTime applyTime;
	//申请类型(AT0001订房，AT0002退房)
	private String applyType;
	//预定天数
	private int applyDays;
	//审核人
	private String checkUserId;
	//审核日期
	private LocalDateTime checkDate;
	//备注
	private String remark;
	// 状态：VALID(生效)、INVALID(失效)、DELETED(已删除)
	private String status;
	// 创建人
	private String createUserId;
	// 创建时间
	private String createTime;
	// 修改人
	private String updateUserId;
	// 最后修改时间
	private String latestUpdateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyCardId() {
		return applyCardId;
	}

	public void setApplyCardId(String applyCardId) {
		this.applyCardId = applyCardId;
	}

	public LocalDateTime getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(LocalDateTime applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public int getApplyDays() {
		return applyDays;
	}

	public void setApplyDays(int applyDays) {
		this.applyDays = applyDays;
	}

	public String getCheckUserId() {
		return checkUserId;
	}

	public void setCheckUserId(String checkUserId) {
		this.checkUserId = checkUserId;
	}

	public LocalDateTime getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(LocalDateTime checkDate) {
		this.checkDate = checkDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getLatestUpdateTime() {
		return latestUpdateTime;
	}

	public void setLatestUpdateTime(String latestUpdateTime) {
		this.latestUpdateTime = latestUpdateTime;
	}
}
