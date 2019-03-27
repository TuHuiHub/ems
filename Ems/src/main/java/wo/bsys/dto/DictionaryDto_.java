package wo.bsys.dto;

import wo.common.util.WoUtil;
import wo.bsys.po.Dictionary;

/**
 * PO实体Dictionary对应的DTO父类.这是自动生成的代码,请不要修改.如要添加属性或者方法,请在其子类DTO中修改.
 *
 * @author cailei
 */
class DictionaryDto_ {

    /**
     * 主键id
     */
    private java.lang.String id;

    /**
     * 属性dicType
     */
    private java.lang.String dicType;
    /**
     * 属性val
     */
    private java.lang.String val;
    /**
     * 属性name
     */
    private java.lang.String name;
    /**
     * 属性description
     */
    private java.lang.String description;
    /**
     * 属性params
     */
    private java.lang.String params;


    /**
     * 无参构造函数
     */
    public DictionaryDto_() {
    }

    /**
     * 构造函数,通过po构造dto
     */
    public DictionaryDto_(Dictionary po) {
        // 设置主键id
        this.id = po.getId();
        // 设置属性dicType
        this.dicType = po.getDicType();
        // 设置属性val
        this.val = po.getVal();
        // 设置属性name
        this.name = po.getName();
        // 设置属性description
        this.description = po.getDescription();
        // 设置属性params
        this.params = po.getParams();

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
     * 属性dicType的getter方法
     */
    public java.lang.String getDicType() {
        return this.dicType;
    }

    /**
     * 属性dicType的setter方法
     */
    public void setDicType(java.lang.String dicType) {
        this.dicType = dicType;
    }

    /**
     * 属性val的getter方法
     */
    public java.lang.String getVal() {
        return this.val;
    }

    /**
     * 属性val的setter方法
     */
    public void setVal(java.lang.String val) {
        this.val = val;
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
     * 属性params的getter方法
     */
    public java.lang.String getParams() {
        return this.params;
    }

    /**
     * 属性params的setter方法
     */
    public void setParams(java.lang.String params) {
        this.params = params;
    }


    /**
     * 将当前对象转化为po
     *
     * @return
     */
    public Dictionary createPO() {
        Dictionary po = new Dictionary();
        // 设置PO主键id
        if (WoUtil.isEmpty(this.id)) {
            po.setId(java.util.UUID.randomUUID().toString());
        } else {
            po.setId(this.id);
        }
        // 设置PO属性dicType
        po.setDicType(this.dicType);
        // 设置PO属性val
        po.setVal(this.val);
        // 设置PO属性name
        po.setName(this.name);
        // 设置PO属性description
        po.setDescription(this.description);
        // 设置PO属性params
        po.setParams(this.params);

        return po;
    }

    /**
     * @param po
     */
    public void updatePO(Dictionary po) {
        // 设置PO属性dicType
        po.setDicType(this.dicType);
        // 设置PO属性val
        po.setVal(this.val);
        // 设置PO属性name
        po.setName(this.name);
        // 设置PO属性description
        po.setDescription(this.description);
        // 设置PO属性params
        po.setParams(this.params);

    }

    @Override
    public String toString() {
        return "DictionaryDto_{" +
                "id='" + id + '\'' +
                ", dicType='" + dicType + '\'' +
                ", val='" + val + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}
