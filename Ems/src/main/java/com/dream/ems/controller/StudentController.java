package com.dream.ems.controller;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.dream.ems.dto.StudentDto;
import com.dream.ems.po.College;
import com.dream.ems.service.CollegeService;
import com.dream.ems.service.StudentService;

import wo.bsys.dto.DictionaryDto;
import wo.bsys.service.DictionaryService;
import wo.bsys.service.UserService;
import wo.bsys.util.BSysConstant;
import wo.bsys.util.BSysUtil;
import wo.bsys.vo.WoDataTable;
import wo.bsys.vo.WoUser;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoUtil;

@Controller
@RequestMapping("/staff/student")
@SessionAttributes({BSysConstant.SESSION_USER,"studentInfo"})
public class StudentController {
	
	private Logger LOG = LogManager.getLogger(StudentController.class);
	
	@Resource
	private StudentService studentService;
	
	@Resource
	private CollegeService collegeService;
	
	@Resource
	private DictionaryService dictionaryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<StudentDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
		WoPage<StudentDto> page = studentService.getPageData(start, length, searchContent, dir);
		return new WoDataTable<StudentDto>(page, draw);
	}
	
	@GetMapping("/create")
	public String create(Map<String,Object>map){
		List<College> colleges = collegeService.getAllCollege();
		List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
		map.put("url","admin/staff/s_create.jsp");
		map.put("genders",genders);
		map.put("colleges",colleges);
		return "main";
	}
	
	@PostMapping("/create")
	public String create(StudentDto dto,Map<String,Object>map){
		LOG.info(dto);
		studentService.createStudent(dto);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(String id,Map<String,Object>map){
		StudentDto dto = studentService.findById(id);
		List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
		map.put("formData",dto);
		map.put("genders",genders);
		map.put("url","admin/staff/s_update.jsp");
		return "main";
	}
	
	@PostMapping("/update")
	public String update(StudentDto dto,Map<String, Object>map){
		studentService.updateStudent(dto);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public WoResultCode delete(String[] id){
		studentService.deleteStudent(id);
		return WoResultCode.getSuccessCode().setMsg("删除学生用户成功！");
	}
	
	/*------------------------------------------------------------------------------------------------*/
	 
	 
	
	@GetMapping("/staff/list")
	@ResponseBody
	public StudentDto getDataTable(Map<String,Object>map) {
		WoUser u = BSysUtil.getCurrentUser(map);
		String id = u.getLoginName();
		StudentDto studentDto= studentService.getStudent(id);
		map.put("studentInfo", studentDto);
		return studentDto;
	}
	
	@GetMapping("/staff/updateinfo")	
	public String updateInfo(Map<String,Object>map) {
		map.put("url", "student/staff/updateinfo.jsp");
		return "main";
	}

	@PostMapping("/staff/updateinfo")	
	public String updateInfo(Map<String,Object>map,StudentDto dto) {
		studentService.updateStudent(dto);
		return "redirect:/";
	}
	
	@GetMapping("/staff/updatepassword")
	public String updatepassword(Map<String,Object>map) {
		map.put("url", "student/staff/updatepassword.jsp");
		return "main";
	}
	@GetMapping("/staff/verifypassword")
	@ResponseBody
	public String updatePassword(Map<String,Object>map ,String password) {
		String falg = "0";
		WoUser user = (WoUser) map.get(BSysConstant.SESSION_USER);
		String id = user.getLoginName();
		StudentDto studentDto= studentService.getStudent(id);
		String md5 = WoUtil.getMD5(studentDto.getStuNo(), password);
		if (md5.equals(studentDto.getUserPassword())) {
			falg="1";
		}
		return falg;
	}
	
	@Resource
	private UserService userService;
	
	@PostMapping("/staff/updatepassword")
	public String updatePassword2(Map<String,Object>map ,String newpassword,SessionStatus s) {
		WoUser user = (WoUser) map.get(BSysConstant.SESSION_USER);
		String md5 = WoUtil.getMD5(user.getLoginName(), newpassword);
		user.setPassword(md5);
		userService.update(user);
		map.clear();
		s.setComplete();
		return "redirect:/";
	}
	
	@Resource
	@Qualifier("studentExportView")
	private View studentExportView;
	
	@GetMapping("/export")
	ModelAndView export(){
		ModelAndView m = new ModelAndView();
		List<StudentDto> studentDtos = studentService.getAll();
		m.addObject("studentDtos",studentDtos);
		m.setView(studentExportView);
		return m;
	}
	
}
