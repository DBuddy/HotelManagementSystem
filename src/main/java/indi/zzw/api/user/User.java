package indi.zzw.api.user;

public class User {
	//主键
	private String id;
	//用户密码表ID
	private String userPasswordId;
	//用户身份证号码
	private String cardId;
	//用户姓名
	private String name;
	//用户角色(0:酒店管理员;1：酒店员工;2：酒店顾客)
	private Integer role;
	//用户手机号
	private String telephone;
	//用户邮箱
	private String email;
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

	public String getUserPasswordId() {
		return userPasswordId;
	}

	public void setUserPasswordId(String userPasswordId) {
		this.userPasswordId = userPasswordId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
