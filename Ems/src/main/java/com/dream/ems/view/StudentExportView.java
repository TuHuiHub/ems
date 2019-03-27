package com.dream.ems.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.dream.ems.dto.StudentDto;

@Component
public class StudentExportView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Sheet sh = workbook.createSheet("学生列表");
		CellStyle cellStyle =  workbook.createCellStyle();
		DataFormat createDataFormat =  workbook.createDataFormat();
		cellStyle.setDataFormat(createDataFormat.getFormat("yyyy年MM月dd日"));
		Row header = sh.createRow(0);
		Cell id = header.createCell(0, CellType.STRING);
		id.setCellValue("学号");
		Cell name = header.createCell(1, CellType.STRING);
		name.setCellValue("姓名");
		Cell sex = header.createCell(2, CellType.STRING);
		sex.setCellValue("性别");
		Cell birthday = header.createCell(3, CellType.STRING);
		birthday.setCellValue("出生日期");
		Cell grade = header.createCell(4, CellType.STRING);
		grade.setCellValue("入学时间");
		Cell college = header.createCell(5, CellType.STRING);
		college.setCellValue("所属学院");
		Cell major = header.createCell(6, CellType.STRING);
		major.setCellValue("所属专业");
		
		@SuppressWarnings("unchecked")
		List<StudentDto> dtos = (List<StudentDto>) map.get("studentDtos");
		for (int i = 0; i < dtos.size(); i++) {
			StudentDto dto = dtos.get(i);
			Row row = sh.createRow(i + 1);
			id = row.createCell(0, CellType.STRING);
			id.setCellValue(dto.getStuNo());
			name = row.createCell(1, CellType.STRING);
			name.setCellValue(dto.getName());
			sex = row.createCell(2, CellType.STRING);
			sex.setCellValue(dto.getSex());
			birthday = row.createCell(3);
			birthday.setCellStyle(cellStyle);
			birthday.setCellValue(dto.getBirthday());
			grade = row.createCell(4);
			grade.setCellStyle(cellStyle);
			grade.setCellValue(dto.getGrade());
			college = row.createCell(5, CellType.STRING);
			college.setCellValue(dto.getCollegeName());
			major = row.createCell(6, CellType.STRING);
			major.setCellValue(dto.getMajorName());
		}
	}
}
