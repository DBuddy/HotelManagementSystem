package indi.zzw.api.check_in_log;

public class CheckInLog {
	// 入住记录Id
	private String id;
	// 入住人Id
	private String userId;
	// 入住人姓名
	private String userName;
	// 用户身份证号码
	private String cardId;
	// 押金
	private String downpayment;
	// 入住日期
	private Integer check_in_date;
	// 退房日期
	private Integer check_out_date;
	// 入住天数
	private String check_in_days;
	// 备注
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(String downpayment) {
		this.downpayment = downpayment;
	}

	public Integer getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Integer check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Integer getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Integer check_out_date) {
		this.check_out_date = check_out_date;
	}

	public String getCheck_in_days() {
		return check_in_days;
	}

	public void setCheck_in_days(String check_in_days) {
		this.check_in_days = check_in_days;
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
