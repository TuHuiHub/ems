package com.dream.ems.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.dream.ems.dto.StudentDto;
import com.dream.ems.po.Student;
import com.dream.ems.repository.CollegeRepositiry;
import com.dream.ems.repository.MajorRepository;
import com.dream.ems.repository.StudentRepository;
import com.dream.ems.service.StudentService;

import wo.bsys.repository.UserRepository;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentRepository StudentRepository;
	
	@Override
	public WoPage<StudentDto> getPageData(Long start, Long length, String searchContent, String dir) {
		Pageable pageInput = PageRequest.of(start.intValue() / length.intValue(), length.intValue());
		// 调用repository方法，获取po数据
		Page<Student> pageData = null;
		if (WoUtil.isEmpty(searchContent)) {
			pageData = StudentRepository.findAll(pageInput);
		} else {
			pageData = StudentRepository.findAllByNameLike("%" + searchContent + "%", pageInput);
		}
		// 将PO转化为DTO
		WoPage<StudentDto> pr = StudentDto.getPageData(pageData.getContent(), pageData.getTotalElements());
		return pr;
	}
	@Override
	public void createStudent(StudentDto dto) {
		Student po = dto.createPo();
		StudentRepository.save(po);
		
	}
	@Override
	public StudentDto findById(String id) {
		Student student = StudentRepository.findById(id).get();
		StudentDto dto = new StudentDto(student);
		return dto;
	}
	@Override
	public void updateStudent(StudentDto dto) {
		Student po = StudentRepository.findById(dto.getStuNo()).get();
		dto.updatePo(po);
		StudentRepository.save(po);
	}
	@Override
	public void deleteStudent(String[] id) {
		StudentRepository.deleteByStuNoIn(id);
	}
	@Override
	public StudentDto getStudent(String id) {
		Student student = StudentRepository.findById(id).get();
		StudentDto studentDto = new StudentDto(student);
		return studentDto;
	}

	@Override
	public List<StudentDto> getAll() {
		List<Student> pos = StudentRepository.findAll();
		List<StudentDto> dtos = StudentDto.getDtos(pos);
		return dtos;
	}

	@Resource
	private StudentRepository studentRepository;

	@Override
	public List<StudentDto> findAllByClazzId(String id, String dir) {
		List<StudentDto> dtos = StudentDto.getDtos(studentRepository.findAllByClazz(id));
		if("desc".equals(dir)) {
			Collections.sort(dtos, new Comparator<StudentDto>() {
				@Override
				public int compare(StudentDto o1, StudentDto o2) {
					return Integer.valueOf(o2.getStuNo())-Integer.valueOf(o1.getStuNo());
				}
			});
		}
		return dtos;
	}


}
