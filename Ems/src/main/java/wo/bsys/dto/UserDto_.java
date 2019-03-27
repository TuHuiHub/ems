package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import wo.common.util.WoUtil;
import wo.bsys.po.Role;
import wo.bsys.po.User;

/**
 * PO实体User对应的DTO父类.这是自动生成的代码,请不要修改.如要添加属性或者方法,请在其子类DTO中修改.
 * @author 
 */
class UserDto_ {

	/**
	 * 主键id
	 */
	private java.lang.String id;

	/**
	 * 属性loginName
	 */
	private java.lang.String loginName;
	/**
	 * 属性password
	 */
	private java.lang.String password;
	/**
	 * 属性createTime
	 */
	private java.util.Date createTime;
	/**
	 * 属性passwordTime
	 */
	private java.util.Date passwordTime;

	/**
	 * 对应PO的roles属性,多对多关联实体Role的主键值,如有多个以逗号隔开
	 */
	private String rolesId = "";

	/**
	 * 对应PO的roles属性,多对多关联实体Role的name属性值,如有多个以逗号隔开
	 */
	private String rolesName = "";
	

	
	/**
	 * 无参构造函数
	 */
	public UserDto_() {
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public UserDto_(User po) {
			// 设置主键id
		this.id = po.getId();
				// 设置属性loginName
		this.loginName = po.getLoginName();
			// 设置属性password
		this.password = po.getPassword();
			// 设置属性createTime
		this.createTime = po.getCreateTime();
			// 设置属性passwordTime
		this.passwordTime = po.getPasswordTime();
		
			// 设置DTO的roles属性值
		for (Role p : po.getRoles()) {
			if (!"".equals(rolesId)) {
				rolesId += ",";
				rolesName += ",";
			}
			rolesId += p.getId();
			rolesName += p.getName();
		}
				}

	
	/**
	 * 主键id的getter方法
	 */
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 主键id的setter方法
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	
	/**
	 * 属性loginName的getter方法
	 */
		public java.lang.String getLoginName() {
		return this.loginName;
	}

	/**
	 * 属性loginName的setter方法
	 */
		public void setLoginName(java.lang.String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * 属性password的getter方法
	 */
		public java.lang.String getPassword() {
		return this.password;
	}

	/**
	 * 属性password的setter方法
	 */
		public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	/**
	 * 属性createTime的getter方法
	 */
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
		public java.util.Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 属性createTime的setter方法
	 */
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 属性passwordTime的getter方法
	 */
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
		public java.util.Date getPasswordTime() {
		return this.passwordTime;
	}

	/**
	 * 属性passwordTime的setter方法
	 */
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		public void setPasswordTime(java.util.Date passwordTime) {
		this.passwordTime = passwordTime;
	}

	/**
	 * 属性rolesId的getter方法
	 */
	public String getRolesId() {
		return rolesId;
	}

	/**
	 * 属性rolesId的setter方法
	 */
	public void setRolesId(String rolesId) {
		this.rolesId = rolesId;
	}

	/**
	 * 属性rolesName的getter方法
	 */
	public String getRolesName() {
		return rolesName;
	}

	/**
	 * 属性rolesName的setter方法
	 */
	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	/**
	 * 将当前对象转化为po
	 * @return
	 */
	public User createPO() {
		User po = new User();
			// 设置PO主键id
					if (WoUtil.isEmpty(this.id)) {
				po.setId(java.util.UUID.randomUUID().toString());
			} else {
				po.setId(this.id);
			}
						// 设置PO属性loginName
				po.setLoginName(this.loginName);
					// 设置PO属性password
				po.setPassword(WoUtil.getMD5(id, password));
					// 设置PO属性createTime
				po.setCreateTime(new java.util.Date());
					// 设置PO属性passwordTime
				po.setPasswordTime(this.passwordTime);
				
			// 设置PO的roles属性值
		List<Role> roles = new ArrayList<Role>();
		String[] rolesIdArray = WoUtil.splitIds(rolesId);
		for (String id : rolesIdArray) {
			Role p = new Role ();
			p.setId(id);
			roles.add(p);
		}
		po.setRoles(roles);
				return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(User po) {
			// 设置PO属性loginName
		po.setLoginName(this.loginName);
			// 设置PO属性password
		po.setPassword(WoUtil.getMD5(id, password));
			// 设置PO属性createTime
		po.setCreateTime(this.createTime);
			// 设置PO属性passwordTime
		po.setPasswordTime(this.passwordTime);
		
			// 设置PO的roles属性值:M2M
		List<Role> roles = new ArrayList<Role>();
		String[] rolesIdArray = WoUtil.splitIds(rolesId);
		for (String id : rolesIdArray) {
			Role p = new Role ();
			p.setId(id);
			roles.add(p);
		}
		po.setRoles(roles);
			}
}
