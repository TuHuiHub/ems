package com.dream.ems.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.dream.ems.dto.CourseTableDto;
import com.dream.ems.po.*;
import com.dream.ems.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.CourseDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.vo.SelectCourseData;

import wo.bsys.dto.DictionaryDto;
import wo.bsys.po.Dictionary;
import wo.bsys.repository.DictionaryRepository;
import wo.bsys.service.DictionaryService;
import wo.bsys.vo.WoDataTable;
import wo.bsys.vo.WoSelectorParams;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoJsonUtil;

/**
 * @author huracan
 * @date 2018年12月8日
 */
@Controller
@RequestMapping("/collegeinfo/course")
@SessionAttributes("major")
public class CourseController {

    @Resource
    private MajorService majorService;
    @Resource
    private CollegeService collegeService;
    @Resource
    private TeacherService teacherService;
    @Resource // @Autowired
    private CourseService courseService;
    @Resource
    private ClassRoomService classRoomService;
    @Resource
    private ClazzService clazzService;
    @Resource
    private CourseTableService courseTableService;
    @Resource
    private DictionaryRepository dictionaryRepository;

    @GetMapping("/query")
    String query(String id, Map<String, Object> map) {
        // 设置页面右下方的jsp路径
        map.put("url", "collegeinfo/course/main.jsp");
        MajorDto dto = majorService.getById(id);
        map.put("major", dto);
        return "main";
    }

    /**
     * 根据学院查专业
     *
     * @param draw
     * @param start
     * @param length
     * @param searchContent
     * @param dir
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public WoDataTable<CourseDto> getDataTable(Integer draw, Long start, Long length,
                                               @RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir, Map<String, Object> map) {
        MajorDto dto = (MajorDto) map.get("major");
        WoPage<CourseDto> page = courseService.getPageData(dto, start, length, searchContent, dir);
        return new WoDataTable<CourseDto>(page, draw);
    }

    /**
     * 根据学院查专业
     *
     * @param draw
     * @param start
     * @param length
     * @param searchContent
     * @param dir
     * @return
     */
    @RequestMapping("/allList")
    @ResponseBody
    public WoDataTable<CourseDto> getAllDataTable(Integer draw, Long start, Long length,
                                                  @RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir, Map<String, Object> map) {
        WoPage<CourseDto> page = courseService.getPageData(start, length, searchContent, dir);
        return new WoDataTable<CourseDto>(page, draw);
    }

    /**
     * 专业课创建
     */
    @GetMapping("/create")
    String create(String id, Map<String, Object> map) {
        // 设置页面右下方的jsp路径
        map.put("url", "collegeinfo/course/create.jsp");
        MajorDto dto = majorService.getById(id);
        map.put("major", dto);
        return "main";
    }

    @PostMapping("/create")
    String create(CourseDto dto, Map<String, Object> map) {
        courseService.create(dto);
        map.put("url", "collegeinfo/course/main.jsp");
        return "main";
    }


    /**
     * 公共课创建
     */
    @GetMapping("/publicCreate")
    String publicCreate(Map<String, Object> map) {
        // 设置页面右下方的jsp路径
        map.put("url", "admin/course/create.jsp");
        return "main";
    }

    @PostMapping("/publicCreate")
    String publicCreate(CourseDto dto, Map<String, Object> map) {
        courseService.create(dto);
        map.put("url", "admin/course/main.jsp");
        return "main";
    }


    /**
     * 公共课修改
     */
    @GetMapping("/publicUpdate")
    String publicUpdate(String id, Map<String, Object> map) {
        CourseDto dto = courseService.getById(id);
        map.put("course", dto);
        map.put("url", "admin/course/update.jsp");
        return "main";
    }

    @PostMapping("/publicUpdate")
    String publicUpdate(CourseDto dto, Map<String, Object> map) {
        courseService.update(dto);
        map.put("url", "admin/course/main.jsp");
        return "main";
    }

    /**
     * 修改课程
     */
    @GetMapping("/update")
    String update(String id, Map<String, Object> map) {
        CourseDto dto = courseService.getById(id);
        map.put("course", dto);
        map.put("url", "collegeinfo/course/update.jsp");
        return "main";
    }

    @PostMapping("/update")
    String update(CourseDto dto, Map<String, Object> map) {
        courseService.update(dto);
        map.put("url", "collegeinfo/course/main.jsp");
        return "main";
    }

    @PostMapping("/delete")
    @ResponseBody
    WoResultCode delete(String[] id) {
        courseService.delete(id);
        return WoResultCode.getSuccessCode().setMsg("删除成功...");
    }

    @PostMapping("/checkCourse")
    @ResponseBody
    WoResultCode ckeckCourse(String majorId, String semesterId) {
        List<Course> courses = courseService.getAllByMajorIdAndSemesterId(majorId, semesterId);
        if (courses.size() == 0) {
            return new WoResultCode(0, "此专业还未安排课程！");
        } else {
            return WoResultCode.getSuccessCode();
        }
    }

    @GetMapping("/selectCourse")
    String selectCourse(String collegeId, String majorId, String semesterId, Map<String, Object> map) {
        List<Course> courses = courseService.getAllByMajorIdAndSemesterId(majorId, semesterId);
        List<Teacher> teachers = teacherService.getAllByCollegeId(collegeId);
        College college = collegeService.getCollege(collegeId);
        // 查询指定时间段空闲的教室
        List<ClassRoom> classRooms = classRoomService.getAllRoomsByTime("1", "1");
        // 查询未排满该课程的班级
        List<Clazz> clazzes = clazzService.getFreeClazz(majorId, courses.get(0).getId());
        List<CourseTableDto> courseTableList = courseTableService.findAllByCourseAndTeacher(courses.get(0).getId(), teachers.get(0).getJobNo());
        Major major = majorService.getMajor(majorId);
        map.put("courses", courses);
        map.put("teachers", teachers);
        map.put("college", college);
        map.put("major", major);
        map.put("classRooms", classRooms);
        map.put("clazzes", clazzes);
        map.put("semesterId", semesterId);
        map.put("courseTableList", courseTableList);
        map.put("url", "admin/course/c_plan.jsp");
        return "main";
    }

    /*@PostMapping("/selectCourse")
    @ResponseBody
    WoResultCode selectCourse(@RequestBody List<SelectCourseData> scds, Map<String, Object> map) {
        courseService.selectCourse(scds);
        return WoResultCode.getSuccessCode().setMsg("添加课程表成功");
    }*/

    @PostMapping("/selectCourse")
    @ResponseBody
    WoResultCode selectCourse(CourseTableDto dto, HttpServletResponse response) {
        Map<String, Object> map = courseService.selectCourse(dto);
        int status = (int) map.get("status");
        if (status == 1) {
            return WoResultCode.getUnknownCode().setMsg("该时段此教师已安排课程！");
        } else if (status == 2) {
            return WoResultCode.getUnknownCode().setMsg("该时段教室已被占用！");
        } else if (status == 3) {
            return WoResultCode.getUnknownCode().setMsg("该班级本周已无该课程！");
        }
        return WoResultCode.getSuccessCode().setContent(map);
    }

    @PostMapping("/changeCourse")
    @ResponseBody
    WoResultCode changeCourse(String majorId, String courseId) {
        Map<String, Object> map = new HashMap<>();
        List<Clazz> clazzes = clazzService.getFreeClazz(majorId, courseId);
        map.put("clazzes", clazzes);
        CourseDto course = courseService.getById(courseId);
        map.put("startWeek", course.getStartWeek());
        map.put("endWeek", course.getEndWeek());
        return WoResultCode.getSuccessCode().setContent(map);
    }

    @PostMapping("/changeTeacher")
    @ResponseBody
    WoResultCode changeTeacher(String courseId, String teacherId) {
        List<CourseTableDto> courseTableList = courseTableService.findAllByCourseAndTeacher(courseId, teacherId);
        return WoResultCode.getSuccessCode().setContent(courseTableList);
    }
}