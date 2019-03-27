package wo.bsys.po;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 数据字典
 * @author 
 * @date Nov 4, 2018
 */
@Entity
@Table(name="bsys_dictionary")
public class Dictionary  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6668800196790039529L;


	/**
	 * ID
	 */
	@Id
	@Column(length = 50)
	private String id;
	
	/**
	 * 类型
	 */
	@Column(length = 50, nullable = false)
	private String dicType;
	
	/**
	 * 值
	 */
	@Column(length = 50, nullable = false)
	private String val;

	/**
	 * 键
	 */
	@Column(length = 50, nullable = false)
	private String name;
	
	/**
	 * 描述
	 */
	@Column(length = 100)
	private String description;

	/**
	 * 参数
	 */
	@Column(length = 500)
	private String params;
	
	public Dictionary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dictionary(String id, String dicType, String val, String name, String description) {
		super();
		this.id = id;
		this.dicType = dicType;
		this.val = val;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Dictionary{" +
				"id='" + id + '\'' +
				", dicType='" + dicType + '\'' +
				", val='" + val + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", params='" + params + '\'' +
				'}';
	}
}
