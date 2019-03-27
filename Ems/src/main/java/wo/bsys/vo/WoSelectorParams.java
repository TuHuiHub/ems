package wo.bsys.vo;

/**
 * 选择器参数
 * @date Nov 18, 2018
 */
public class WoSelectorParams {

	private String formId;
	
	private String idField;
	
	private String nameField;
	
	private Boolean singleSelect = true;

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getIdField() {
		return idField;
	}

	public void setIdField(String idField) {
		this.idField = idField;
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	public Boolean getSingleSelect() {
		return singleSelect;
	}

	public void setSingleSelect(Boolean singleSelect) {
		this.singleSelect = singleSelect;
	}
	
}
