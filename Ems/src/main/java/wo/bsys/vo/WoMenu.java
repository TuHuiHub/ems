package wo.bsys.vo;

import java.util.ArrayList;
import java.util.List;

import wo.bsys.po.Menu;

/**
 * BSys系统管理的菜单数据类.
 * 
 *
 */
public class WoMenu {

	/**
	 * id
	 */
	private String id;

	/**
	 * name
	 */
	private String name;

	/**
	 * icon
	 */
	private String icon;

	/**
	 * Whether the menu is active.
	 */
	private Boolean active = false;

	/**
	 * 该菜单链接的url
	 */
	private String url;
	
	/**
	 * 菜单的jsp路径
	 */
	private String page;

	/**
	 * 子菜单
	 */
	private List<WoMenu> children = new ArrayList<WoMenu>();
	
	public WoMenu(String id, String name, String icon, String page) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.page = page;
	}
	
	/**
	 * @param m
	 */
	public WoMenu(Menu m, Boolean active) {
		this(m.getId(), m.getName(), m.getIcon(), m.getPage());
		this.active = active;
	} 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getActive() {
		return active;
	}

	public String getActiveCls () {
		return active ? "active" : "";
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public List<WoMenu> getChildren() {
		return children;
	}

	public void setChildren(List<WoMenu> children) {
		this.children = children;
	}
	
}
