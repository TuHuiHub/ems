package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;

import wo.common.util.WoUtil;
import wo.common.entity.WoPage;
import com.dream.ems.po.Clazz;
import com.dream.ems.po.Major;

/**
 * PO实体Clazz对应的DTO类.
 * @author cailei
 */
public class ClazzDto{

	private String id;

	private String clazzName;

	private String majorId;
	private String majorName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public String getMajorId() {
		return majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "ClazzDto [id=" + id + ", clazzName=" + clazzName + ", majorId=" + majorId + ", majorName=" + majorName
				+ "]";
	}

	/**
	 * 无参构造函数
	 */
	public ClazzDto() {
		super ();
	}

	public ClazzDto(String id, String clazzName, String majorId, String majorName) {
		super();
		this.id = id;
		this.clazzName = clazzName;
		this.majorId = majorId;
		this.majorName = majorName;
	}

	/**
	 * 构造函数,通过po构造dto
	 */
	public ClazzDto(Clazz po) {
		// 设置主键id
		this.id = po.getId();
		// 设置属性clazzName
		this.clazzName = po.getClazzName();
		// 设置DTO的major属性值
		if (po.getMajor() != null) {
			this.majorId = po.getMajor().getId();
			this.majorName = po.getMajor().getName();
		}
	}
	/**
	 * 将当前对象转化为po
	 * @return
	 */
	public Clazz createPO() {
		Clazz po = new Clazz();
		// 设置PO主键id
		if (WoUtil.isEmpty(this.id)) {
			po.setId(java.util.UUID.randomUUID().toString());
		} else {
			po.setId(this.id);
		}
		// 设置PO属性clazzName
		po.setClazzName(this.clazzName);

		// 设置关系数据
		Major major = new Major();
		if (!WoUtil.isEmpty(majorId)) {
			major.setId(this.majorId);
			po.setMajor(major);
		}
		return po;
	}

	/**
	 * @param po
	 */
	public void updatePO(Clazz po) {
		// 设置PO属性clazzName
		po.setClazzName(this.clazzName);

		// 设置PO的major属性
		if (!WoUtil.isEmpty(majorId)) {
			Major major = new Major();
			major.setId(this.majorId);
			po.setMajor(major);
		} else {
			po.setMajor(null);
		}
	}
	/**
	 * 将PO列表数据转化为DTO列表数据
	 * @param pos
	 * @return
	 */
	public static List<ClazzDto> getDtos (List<Clazz> pos) {
		List<ClazzDto> rs = new ArrayList<ClazzDto>();
		for (Clazz r : pos) {
			ClazzDto dto = new ClazzDto(r);
			rs.add(dto);
		}
		return rs;
	}

	/**
	 * 将分页PO数据转化为DTO分页数据
	 * @param pos 当前页的PO数据集合
	 * @param total 数据总行数
	 * @return
	 */
	public static WoPage<ClazzDto> getPageData(List<Clazz> pos, Long total) {
		WoPage<ClazzDto> puDto = new WoPage<ClazzDto>(getDtos(pos), total);
		return puDto;
	}

}
