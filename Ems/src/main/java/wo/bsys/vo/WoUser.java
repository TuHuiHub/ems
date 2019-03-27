package wo.bsys.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import wo.bsys.po.Role;
import wo.bsys.po.User;

/**
 * session中的用户数据
 * 
 * @date 2018年11月13日
 */
public class WoUser implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 8498380110342879997L;

	private String id;

	private String loginName;

	private String password = "111";

	private String headImage;

	private Date createTime;

	private List<WoMenu> menus = new ArrayList<WoMenu>();

	private String rolesId = "";

	private String rolesName = "";

	private String staffIds = "";

	private String staffNames = "";

	private String deptIds = "";

	private String deptNames = "";

	private String staffDeptIds = "";

	private String staffDeptNames = "";

	public WoUser() {
	}

	public WoUser(User po) {
		// 设置主键id
		this.id = po.getId();
		// 设置属性loginName
		this.loginName = po.getLoginName();
		// 设置属性password
		this.password = po.getPassword();
		// 设置属性createTime
		this.createTime = po.getCreateTime();

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

	public String getRolesId() {
		return rolesId;
	}

	public void setRolesId(String rolesId) {
		this.rolesId = rolesId;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

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

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStaffIds() {
		return staffIds;
	}

	public void setStaffIds(String staffIds) {
		this.staffIds = staffIds;
	}

	public String getStaffNames() {
		return staffNames;
	}

	public void setStaffNames(String staffNames) {
		this.staffNames = staffNames;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public String getDeptNames() {
		return deptNames;
	}

	public void setDeptNames(String deptNames) {
		this.deptNames = deptNames;
	}

	public String getStaffDeptIds() {
		return staffDeptIds;
	}

	public void setStaffDeptIds(String staffDeptIds) {
		this.staffDeptIds = staffDeptIds;
	}

	public String getStaffDeptNames() {
		return staffDeptNames;
	}

	public void setStaffDeptNames(String staffDeptNames) {
		this.staffDeptNames = staffDeptNames;
	}

	public List<WoMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<WoMenu> menus) {
		this.menus = menus;
	}

	/**
	 * @return
	 */
	public boolean isAdmin() {
		return "admin".equals(this.getId());
	}

}
