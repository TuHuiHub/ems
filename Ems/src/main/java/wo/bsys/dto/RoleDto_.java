package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.util.WoUtil;
import wo.bsys.po.Role;
import wo.bsys.po.Menu;

/**
 * PO实体Role对应的DTO父类.这是自动生成的代码,请不要修改.如要添加属性或者方法,请在其子类DTO中修改.
 * @author 
 */
class RoleDto_ {

	/**
	 * 主键id
	 */
	private java.lang.String id;

	/**
	 * 属性name
	 */
	private java.lang.String name;
	/**
	 * 属性description
	 */
	private java.lang.String description;

	/**
	 * 对应PO的menus属性,多对多关联实体Menu的主键值,如有多个以逗号隔开
	 */
	private String menusId = "";

	/**
	 * 对应PO的menus属性,多对多关联实体Menu的name属性值,如有多个以逗号隔开
	 */
	private String menusName = "";
	

	
	/**
	 * 无参构造函数
	 */
	public RoleDto_() {
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public RoleDto_(Role po) {
			// 设置主键id
		this.id = po.getId();
				// 设置属性name
		this.name = po.getName();
			// 设置属性description
		this.description = po.getDescription();
		
			// 设置DTO的menus属性值
		for (Menu p : po.getMenus()) {
			if (!"".equals(menusId)) {
				menusId += ",";
				menusName += ",";
			}
			menusId += p.getId();
			menusName += p.getName();
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
	 * 属性name的getter方法
	 */
		public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 属性name的setter方法
	 */
		public void setName(java.lang.String name) {
		this.name = name;
	}
	
	/**
	 * 属性description的getter方法
	 */
		public java.lang.String getDescription() {
		return this.description;
	}

	/**
	 * 属性description的setter方法
	 */
		public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * 属性menusId的getter方法
	 */
	public String getMenusId() {
		return menusId;
	}

	/**
	 * 属性menusId的setter方法
	 */
	public void setMenusId(String menusId) {
		this.menusId = menusId;
	}

	/**
	 * 属性menusName的getter方法
	 */
	public String getMenusName() {
		return menusName;
	}

	/**
	 * 属性menusName的setter方法
	 */
	public void setMenusName(String menusName) {
		this.menusName = menusName;
	}

	/**
	 * 将当前对象转化为po
	 * @return
	 */
	public Role createPO() {
		Role po = new Role();
			// 设置PO主键id
					if (WoUtil.isEmpty(this.id)) {
				po.setId(java.util.UUID.randomUUID().toString());
			} else {
				po.setId(this.id);
			}
						// 设置PO属性name
				po.setName(this.name);
					// 设置PO属性description
				po.setDescription(this.description);
				
			// 设置PO的menus属性值
		List<Menu> menus = new ArrayList<Menu>();
		String[] menusIdArray = WoUtil.splitIds(menusId);
		for (String id : menusIdArray) {
			Menu p = new Menu ();
			p.setId(id);
			menus.add(p);
		}
		po.setMenus(menus);
				return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(Role po) {
			// 设置PO属性name
		po.setName(this.name);
			// 设置PO属性description
		po.setDescription(this.description);
		
			// 设置PO的menus属性值:M2M
		List<Menu> menus = new ArrayList<Menu>();
		String[] menusIdArray = WoUtil.splitIds(menusId);
		for (String id : menusIdArray) {
			Menu p = new Menu ();
			p.setId(id);
			menus.add(p);
		}
		po.setMenus(menus);
			}
}
