package wo.bsys.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 菜单
 * @author 
 * @date 2018年11月13日
 */
@Entity
@Table(name="bsys_menu")
public class Menu {

	/**
	 * ID.
	 */
	@Id
	@Column(length=50)
	private String id;
	
	/**
	 * 名称.必填:是
	 */
	@Column(length = 20)
	private String name;
	
	/**
	 * 编号.排序:asc,必填:是
	 */
	@Column(length = 30)
	private String no;
	
	/**
	 * 图标.必填:是
	 */
	@Column(length=200)
	private String icon;
	
	/**
	 * URL
	 */
	@Column(length=200)
	private String url;
	
	/**
	 * JSP路径
	 */
	@Column(length=200)
	private String page;
	
	/**
	 * 上级菜单
	 */
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;

	/**
	 * 子菜单
	 */
	@OneToMany(mappedBy="parent")
	private List<Menu> children;
	
//	@ManyToMany(mappedBy="menus")
//	private List<Role> roles;
	
	public Menu(String id, String name, String no, String icon, String page, Menu parent) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.icon = icon;
		this.page = page;
		this.parent = parent;
	}

	public Menu() {
		super();
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}
	
	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
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

}
