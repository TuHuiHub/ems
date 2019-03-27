package com.dream.ems.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.dream.ems.dto.CourseDto;
import com.dream.ems.po.*;
import com.dream.ems.service.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.repository.CourseTableStudentRepository;
import com.dream.ems.vo.CourseArray;
import com.dream.ems.vo.CourseVo;
import com.dream.ems.vo.EChartData;
import com.dream.ems.vo.EChartSeries;
import com.dream.ems.vo.TeacherVo;
import com.dream.ems.vo.UpdateCourseData;
import net.sf.json.JSONArray;
import wo.bsys.util.BSysConstant;
import wo.bsys.util.BSysUtil;
import wo.bsys.vo.WoUser;
import wo.bsys.vo.WoDataTable;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoUtil;

@Controller
@RequestMapping("/coursetable")
@SessionAttributes(BSysConstant.SESSION_USER)
public class StudentCourseController {

	private static Logger LOG = LogManager.getLogger(StudentCourseController.class);
	
	@Resource
	private CourseTableService courseTableService;
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private CourseService courseService;
	
	@Resource
	private MajorService  majorService;

	@Resource
	private ClassRoomService classRoomService;
	
	@GetMapping("/majorCoursesCharts")
	@ResponseBody
	EChartData loadMajorCoursesEchartData(String majorId){
		EChartData data = new EChartData();
		Map<String,Integer> cs = new HashMap<>(); 
		List<CourseTableDto> dtos = courseTableService.getByMid(majorId);
		for (CourseTableDto dto : dtos) {
			Integer stuNum = courseTableService.getStuNumberByCtId(dto.getId());
			cs.put(dto.getCourseName(),stuNum);
			
			LOG.info(dto.getCourseName()+"--"+stuNum);
		}
		
		List<String> xAxis = new ArrayList<>();
		for (String courseName : cs.keySet()) {
			xAxis.add(courseName);
		}
		
		Collections.sort(xAxis);
		data.setxAxis(xAxis);
		
		List<Integer> seriesData = new ArrayList<>();
		for(String x:xAxis){
			seriesData.add(cs.get(x));
		}
		data.setSeries(Arrays.asList(new EChartSeries("学生数量", seriesData)));
		return data;
	}
	
	@GetMapping("/courseSelectedCharts")
	@ResponseBody
	EChartData loadCourseSelectedEchartData(String collegeId){
		List<String> jobNoes = teacherService.getAllJobNoByCollegeId(collegeId);
		List<CourseTable> courseTables = courseTableService.getAllByTeacherJobNo(jobNoes);
		Map<String,Integer> cs = new HashMap<>(); 
		LOG.info(courseTables.size());
		for (CourseTable courseTable : courseTables) {
			if(courseTable.getCourse().getIsOptional()){
				Integer stuNum = courseTableService.getStuNumberByCtId(courseTable.getId());
				cs.put(courseTable.getCourse().getName(),stuNum);
			}
		}
		EChartData data = new EChartData();
		List<String> xAxis = new ArrayList<>();
		for (String courseName : cs.keySet()) {
			xAxis.add(courseName);
		}
		Collections.sort(xAxis);
		data.setxAxis(xAxis);
		
		List<Integer> seriesData = new ArrayList<>();
		for(String x:xAxis){
			seriesData.add(cs.get(x));
		}
		data.setSeries(Arrays.asList(new EChartSeries("学生数量", seriesData)));
		return data;
	}
	
	@Resource
	private StudentCourseService studentCourseService;
	
	@RequestMapping("/majorList")
	@ResponseBody
	WoDataTable<MajorDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir){
		WoPage<MajorDto> page = majorService.getCourseTableData(start, length, searchContent, dir);
		return new WoDataTable<>(page, draw);
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<StudentCourseDto> stuCourse(Map<String,Object> map){
		WoUser woUser = BSysUtil.getCurrentUser(map);
		List<StudentCourseDto> studentCourseList = studentCourseService.getStudentList(woUser.getLoginName());
		return studentCourseList;
	}
	
	@GetMapping("/coursetable")
	String getCourseTable(String collegeId,String majorId,Map<String,Object>map){
		List<CourseTableDto> dtos = courseTableService.getCourseTable(collegeId,majorId);
		map.put("collegeId",collegeId);
		map.put("majorId",majorId);
		map.put("courseTableList", dtos);
		map.put("url","admin/course/coursetable.jsp");
		return "main";
	}
	
	@GetMapping("/getCourses")
	@ResponseBody
	private JSONArray getCourses(String majorId,Map<String,Object>map){
		List<Course> courses = courseService.getAllByMajorId(majorId);
		List<CourseVo> vos = CourseVo.getVos(courses);
		return  JSONArray.fromObject(vos);
	}
	
	@GetMapping("/getteachers")
	@ResponseBody
	private JSONArray getteachers(String collegeId,Map<String,Object>map){
		List<Teacher> teachers = teacherService.getAllByCollegeId(collegeId);
		List<TeacherVo> vos = TeacherVo.getVos(teachers);
		return  JSONArray.fromObject(vos);
	}
	
	@PostMapping("/updatecoursetable")
	@ResponseBody
	WoResultCode selectCourse(@RequestBody UpdateCourseData updateCourseData,Map<String,Object>map){
		List<String> courseTableIdstr = updateCourseData.getDelCourseTableIds();
		List<Integer> courseTableIds = new ArrayList<>();
		for (String string : courseTableIdstr) {
			LOG.info(string);
			if(!WoUtil.isEmpty(string)){
				courseTableIds.add(Integer.parseInt(string));
			}
		}
		if(courseTableIds.size()>0){
			courseTableService.deleteByIdIn(courseTableIds);
		}
		List<CourseArray> courseArray = updateCourseData.getCourseArray();
		List<CourseTable> pos = new ArrayList<>();
		for (CourseArray ca : courseArray) {
			CourseTable po = ca.createPo();
			pos.add(po);
		}
		courseTableService.saveCourseTables(pos);
		return WoResultCode.getSuccessCode().setMsg("修改课程表成功！");
	}
	
	@RequestMapping("/deleteall")
	@ResponseBody
	WoResultCode deleteAll(String majorId,Map<String,Object>map){
		courseTableService.deleteByMajorId(majorId);
		return WoResultCode.getSuccessCode().setMsg("删除课程表成功！");
	}
	
	@GetMapping("/studentcourse/list")
	@ResponseBody
	public List<CourseTableDto> getStudentCourseTable(Map<String,Object>map) {
		WoUser user = BSysUtil.getCurrentUser(map);
		String StuNo = user.getLoginName();
		return courseTableService.findAllByClazz(StuNo, "6");
	}
	
	@GetMapping("/course/list")
	@ResponseBody
	WoDataTable<CourseTableDto> getCourseTable(HttpSession session, Integer draw, Long start, Long length,
											   @RequestParam("search[value]") String searchContent, Map<String,Object> map, @RequestParam("order[0][dir]") String dir){
		WoUser user = (WoUser) map.get(BSysConstant.SESSION_USER);
		WoPage<CourseTableDto> page = courseTableService.getAllMyDataTable(start, length, searchContent, dir, user.getId());
		return new WoDataTable<>(page, draw);
	}
	
	@GetMapping("/getElectiveCoursePlanList")
	String electiveCoursePlan(String id,String name,Map<String,Object>map){
		map.put("electiveCourseId",id);
		map.put("electiveCourseName",name);
		map.put("url","admin/course/electiveCoursePlan_main.jsp");
		return "main";
	}
	
	@PostMapping("/course/choose")
	@ResponseBody
	public WoResultCode chooseCourse(String id,Map<String,Object> map) {
		int i = studentCourseService.chooseCourse(id, map);
		if (i == 1) {
			return WoResultCode.getSuccessCode().setMsg("选课成功！");
		} else {
			return WoResultCode.getUnknownCode().setMsg("选课失败");
		}
	}

	@RequestMapping("/electiveCourse/list")
	@ResponseBody
	public WoDataTable<CourseTableDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir,String param,Map<String, Object> map) {
		WoPage<CourseTableDto> page = courseTableService.getPageData(param, start, length, searchContent, dir);
		return new WoDataTable<CourseTableDto>(page, draw);
	}
	
	@GetMapping("/electiveCourse/create")
	String createElectiveCoursePlan(String courseId, Map<String,Object>map){
		CourseDto course = courseService.getById(courseId);
		map.put("course", course);
		// 查询指定时间段空闲的教室
		List<ClassRoom> classRooms = classRoomService.getAllRoomsByTime("1", "1");
		map.put("classRooms", classRooms);
		map.put("url", "admin/course/electiveCoursePlan_create.jsp");
		return "main";
	}
	
	@PostMapping("/electiveCourse/create")
	String createElectiveCoursePlan(CourseTableDto data,Map<String,Object>map){
		courseTableService.saveElectiveCoursePlan(data);
		return "redirect:/";
	}
	
	@GetMapping("/electiveCourse/update")
	public String update(String id,Map<String,Object>map){
		CourseTableDto dto = courseTableService.findById(id);
		map.put("formData",dto);
		map.put("url","admin/course/electiveCoursePlan_update.jsp");
		return "main";
	}
	
	@PostMapping("/electiveCourse/update")
	public String update(CourseTableDto dto,Map<String, Object>map){
		courseTableService.updateCourseTable(dto);
		return "redirect:/";
	}
	
	@PostMapping("/electiveCourse/delete")
	@ResponseBody
	public WoResultCode delete(String[] id){
		courseTableService.deleteCourseTable(id);
		return WoResultCode.getSuccessCode().setMsg("删除该课次成功！");
	}
}
