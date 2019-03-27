package wo.bsys.dto;

import java.util.ArrayList;
import java.util.List;


import wo.common.util.WoUtil;
import wo.bsys.po.Menu;

/**
 * PO实体Menu对应的DTO父类.这是自动生成的代码,请不要修改.如要添加属性或者方法,请在其子类DTO中修改.
 * 
 * @author 
 */
class MenuDto_ {

	/**
	 * 主键id
	 */
	private java.lang.String id;

	/**
	 * 属性name
	 */
	private java.lang.String name;
	/**
	 * 属性no
	 */
	private java.lang.String no;
	/**
	 * 属性icon
	 */
	private java.lang.String icon;
	/**
	 * 属性url
	 */
	private java.lang.String url;
	/**
	 * 属性page
	 */
	private java.lang.String page;

	/**
	 * 对应PO的parent属性,多对一关联实体Menu的主键值
	 */
	private java.lang.String parentId;

	/**
	 * 对应PO的parent属性,多对一关联实体Menu的name属性值
	 */
	private java.lang.String parentName;

	/**
	 * 对应PO的children属性,一对多关联实体Menu的主键值
	 */
	private List<MenuDto> children = new ArrayList<MenuDto>();

	/**
	 * 无参构造函数
	 */
	public MenuDto_() {
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public MenuDto_(Menu po) {
		// 设置主键id
		this.id = po.getId();
		// 设置属性name
		this.name = po.getName();
		// 设置属性no
		this.no = po.getNo();
		// 设置属性icon
		this.icon = po.getIcon();
		// 设置属性url
		this.url = po.getUrl();
		// 设置属性page
		this.page = po.getPage();

		// 设置DTO的parent属性值
		if (po.getParent() != null) {
			this.parentId = po.getParent().getId();
			this.parentName = po.getParent().getName();
		}
		// 设置DTO的children属性值
		this.children = MenuDto.getDtos(po.getChildren());
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
	 * 属性no的getter方法
	 */
	public java.lang.String getNo() {
		return this.no;
	}

	/**
	 * 属性no的setter方法
	 */
	public void setNo(java.lang.String no) {
		this.no = no;
	}

	/**
	 * 属性icon的getter方法
	 */
	public java.lang.String getIcon() {
		return this.icon;
	}

	/**
	 * 属性icon的setter方法
	 */
	public void setIcon(java.lang.String icon) {
		this.icon = icon;
	}

	/**
	 * 属性url的getter方法
	 */
	public java.lang.String getUrl() {
		return this.url;
	}

	/**
	 * 属性url的setter方法
	 */
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	/**
	 * 属性page的getter方法
	 */
	public java.lang.String getPage() {
		return this.page;
	}

	/**
	 * 属性page的setter方法
	 */
	public void setPage(java.lang.String page) {
		this.page = page;
	}

	/**
	 * 属性parentId的getter方法
	 */
	public java.lang.String getParentId() {
		return parentId;
	}

	/**
	 * 属性parentId的setter方法
	 */
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 属性parentName的getter方法
	 */
	public java.lang.String getParentName() {
		return parentName;
	}

	/**
	 * 属性parentName的setter方法
	 */
	public void setParentName(java.lang.String parentName) {
		this.parentName = parentName;
	}

	/**
	 * 属性children的setter方法
	 */
	public List<MenuDto> getChildren() {
		return children;
	}

	/**
	 * 属性children的setter方法
	 */
	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}

	/**
	 * 将当前对象转化为po
	 * 
	 * @return
	 */
	public Menu createPO() {
		Menu po = new Menu();
		// 设置PO主键id
		if (WoUtil.isEmpty(this.id)) {
			po.setId(java.util.UUID.randomUUID().toString());
		} else {
			po.setId(this.id);
		}
		// 设置PO属性name
		po.setName(this.name);
		// 设置PO属性no
		po.setNo(this.no);
		// 设置PO属性icon
		po.setIcon(this.icon);
		// 设置PO属性url
		po.setUrl(this.url);
		// 设置PO属性page
		po.setPage(this.page);

		// 设置关系数据
		Menu parent = new Menu();
		if (!WoUtil.isEmpty(parentId)) {
			parent.setId(this.parentId);
			po.setParent(parent);
		}
		return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(Menu po) {
		// 设置PO属性name
		po.setName(this.name);
		// 设置PO属性no
		po.setNo(this.no);
		// 设置PO属性icon
		po.setIcon(this.icon);
		// 设置PO属性url
		po.setUrl(this.url);
		// 设置PO属性page
		po.setPage(this.page);

		// 设置PO的parent属性:M21
		if (!WoUtil.isEmpty(parentId)) {
			Menu parent = new Menu();
			parent.setId(this.parentId);
			po.setParent(parent);
		} else {
			po.setParent(null);
		}
	}
}
