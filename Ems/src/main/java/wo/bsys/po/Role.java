package wo.bsys.po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色
 * @author cailei
 * @date Nov 4, 2018
 */
@Entity
@Table(name = "bsys_role")
public class Role {

	/**
	 * ID.
	 */
	@Id
	@Column(length = 50)
	private String id;

	/**
	 * 名称.
	 */
	@Column(length = 20)
	private String name;

	/**
	 * 描述
	 */
	@Column(length = 100)
	private String description;

	/**
	 * 菜单
	 */
	@ManyToMany
	@JoinTable(name = "bsys_role_menu", 
		joinColumns = { @JoinColumn(name = "role_id") }, 
		inverseJoinColumns = {@JoinColumn(name = "menu_id") })
	private List<Menu> menus;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> Menus) {
		this.menus = Menus;
	}
	
}
