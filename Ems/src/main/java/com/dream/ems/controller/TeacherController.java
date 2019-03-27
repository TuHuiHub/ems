package com.dream.ems.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.dto.StudentCourseDto;
import com.dream.ems.dto.StudentDto;
import com.dream.ems.dto.TeacherDto;
import com.dream.ems.service.StudentService;
import com.dream.ems.po.College;
import com.dream.ems.service.CollegeService;
import com.dream.ems.service.TeacherService;
import com.dream.ems.vo.WoSelectorParams;

import wo.bsys.dto.UserDto;
import wo.bsys.service.UserService;
import wo.bsys.dto.DictionaryDto;
import wo.bsys.service.DictionaryService;
import wo.bsys.util.BSysConstant;
import wo.bsys.vo.WoDataTable;
import wo.bsys.vo.WoUser;
import wo.common.entity.WoPage;

import wo.common.exception.WoResultCode;
import wo.common.util.WoUtil;
import wo.common.util.WoJsonUtil;

@Controller
@SessionAttributes({BSysConstant.SESSION_USER, "teacherDto", "courseId", "studentDto"})
@RequestMapping("staff/teacher")
public class TeacherController {

    private static Logger LOG = LogManager.getLogger(TeacherController.class);
    @Resource
    private CollegeService collegeService;
    @Resource
    private DictionaryService dictionaryService;
    @Resource // @Autowired
    private TeacherService teacherService;
    @Resource // @Autowired
    private UserService userService;
    @Resource // @Autowired
    private StudentService studentService;

    @GetMapping("/info/update")
    String infoUpdate(Map<String, Object> map) {
        map.put("url", "teacher/staff/update.jsp");
        return "main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public WoDataTable<TeacherDto> getDataTable(Integer draw, Long start, Long length,
                                                @RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
        WoPage<TeacherDto> page = teacherService.getPageData(start, length, searchContent, dir);
        return new WoDataTable<TeacherDto>(page, draw);
    }

    @PostMapping("/info/update")
    public String teacherUpdate(Map<String, Object> map, String password) {
        WoUser woUser = (WoUser) map.get(BSysConstant.SESSION_USER);
        String userId = woUser.getId();
        UserDto dto = new UserDto();
        dto.setPassword(WoUtil.getMD5(userId, password));
        dto.setId(userId);
        userService.updatePassword(dto);
        return "main";
    }

    @RequestMapping("/info")
    String teacherInfo(Map<String, Object> map) {
        map.put("url", "teacher/staff/info.jsp");
        WoUser woUser = (WoUser) map.get(BSysConstant.SESSION_USER);

        String userId = woUser.getId();
        TeacherDto teacherDto = teacherService.getTeacher(userId);
        map.put("teacherDto", teacherDto);

        return "main";
    }


    @GetMapping("/teachercourse/list")
    @ResponseBody
    List<CourseTableDto> teaCourse(Map<String, Object> map) {
        TeacherDto teacherDto = (TeacherDto) map.get("teacherDto");
        String tId = teacherDto.getJobNo();
        return teacherService.getTeacherListBySemester(tId, "6");
    }

    @RequestMapping("/studentinfo/list")
    @ResponseBody
    WoDataTable<StudentDto> getStudentList(Integer draw, Map<String, Object> map, Long start, Long length,
                                           @RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir, String clazzId) {
        System.out.println(clazzId + "xxxx");
        List<StudentDto> studentDtos = studentService.findAllByClazzId(clazzId, dir);
        WoPage<StudentDto> page = new WoPage<>(studentDtos, 35L);
        return new WoDataTable<>(page, draw);
    }

    @GetMapping("student/info")
    String studentInfo(Map<String, Object> map, String clazzId) {
        map.put("clazzId", clazzId);
        map.put("url", "teacher/course/studentinfo.jsp");
        return "main";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> map) {
        List<College> colleges = collegeService.getAllCollege();
        List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
        map.put("url", "admin/staff/t_create.jsp");
        map.put("genders", genders);
        map.put("colleges", colleges);
        return "main";
    }

    @PostMapping("/create")
    public String create(TeacherDto dto, Map<String, Object> map) {
        LOG.info(dto);
        teacherService.createTeacher(dto);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(String id, Map<String, Object> map) {
        TeacherDto dto = teacherService.findById(id);
        List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
        map.put("formData", dto);
        map.put("genders", genders);
        map.put("url", "admin/staff/t_update.jsp");
        return "main";
    }

    @PostMapping("/update")
    public String update(TeacherDto dto, Map<String, Object> map) {
        LOG.info(dto);
        teacherService.updateTeacher(dto);

        return "redirect:/";
    }

    @PostMapping("/delete")
    @ResponseBody
    public WoResultCode delete(String[] id) {
        teacherService.deleteTeacher(id);
        return WoResultCode.getSuccessCode().setMsg("删除教师用户成功！");
    }

    @GetMapping("/lookStudentInfo")
    String lookStudentInfo(String id, Map<String, Object> map) {
        LOG.info("student********:" + id);
        StudentDto studentDto = studentService.findById(id);
        LOG.info("studentDto:" + studentDto);
        map.put("studentDto", studentDto);
        map.put("url", "teacher/course/lookStudentInfo.jsp");
        return "main";
    }

    @PostMapping("/selector")
    public String loadSelector(WoSelectorParams params, Map<String, Object> map) {
        map.put("selectorParams", WoJsonUtil.toString(params));
        return "admin/staff/t_selector";
    }
}
