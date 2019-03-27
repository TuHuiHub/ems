package wo.bsys.po;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 用户
 * @author 
 * @date Nov 4, 2018
 */
@Entity
@Table(name = "bsys_user")
public class User {

	/**
	 * ID
	 */
	@Id
	@Column(length = 50)
	private String id;

	/**
	 * 登录名.
	 */
	@Column(length = 20)
	private String loginName;

	/**
	 * 密码.
	 */
	@Column(length = 50)
	private String password = "111";

	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	/**
	 * 修改密码时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date passwordTime;
	

	/**
	 * 角色
	 */
	@ManyToMany // (fetch=FetchType.EAGER)
	@JoinTable(name = "bsys_user_role", joinColumns = { @JoinColumn(name = "user_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "role_id") })
	private List<Role> roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getPasswordTime() {
		return passwordTime;
	}

	public void setPasswordTime(Date passwordTime) {
		this.passwordTime = passwordTime;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", createTime=" + createTime
				+ ", passwordTime=" + passwordTime + "]";
	}
	
	
}
