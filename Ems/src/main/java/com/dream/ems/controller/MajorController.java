package com.dream.ems.controller;
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

import com.dream.ems.dto.CollegeDto;
import com.dream.ems.dto.MajorDto;
import com.dream.ems.po.Major;
import com.dream.ems.service.CollegeService;
import com.dream.ems.service.MajorService;
import com.dream.ems.vo.WoSelectorParams;

import net.sf.json.JSONArray;
import wo.bsys.util.BSysConstant;
import wo.bsys.vo.WoDataTable;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoJsonUtil;

@Controller
@RequestMapping("/collegeinfo/major")
@SessionAttributes(value={BSysConstant.SESSION_USER,"college"})
public class MajorController {
	
	private Logger LOG = LogManager.getLogger(MajorController.class);
	
	@Resource // @Autowired
	private CollegeService collegeService;
	
	@Resource
	private MajorService majorService;
	
	@RequestMapping("/show")
	@ResponseBody
	private JSONArray showMajorsByCollegeId(String collegeId,Map<String,Object>map){
		List<Major> majors = majorService.getMajorsByCollegeId(collegeId);
		return JSONArray.fromObject(majors);
	}
	
	@GetMapping("/query")
	String query (String id, Map<String, Object>map) {
		// 设置页面右下方的jsp路径
		map.put("url", "collegeinfo/major/main.jsp");
		CollegeDto dto = collegeService.getById (id);
		map.put("college", dto);
		return "main";
	}
	
	/**
	 * 根据学院查专业
	 * @param id
	 * @param draw
	 * @param start
	 * @param length
	 * @param searchContent
	 * @param dir
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<MajorDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir, Map<String, Object> map) {
		CollegeDto dto = (CollegeDto) map.get("college");
		WoPage<MajorDto> page = majorService.getPageData(dto, start, length, searchContent, dir);
		return new WoDataTable<MajorDto>(page, draw);
	}
		
	/**
	 * @param map
	 * @return
	 */

	@GetMapping("/create")
	String create (String id, Map<String, Object>map) {
		// 设置页面右下方的jsp路径
		map.put("url", "collegeinfo/major/create.jsp");
		CollegeDto dto = collegeService.getById (id);
		map.put("college", dto);
		return "main";
	}
	
	@PostMapping("/create")
	String create (MajorDto dto, Map<String, Object>map) {
		LOG.info(dto.getCollegeId());
		majorService.create(dto);		
		map.put("url", "collegeinfo/major/main.jsp");
		return "main";
	}
	
	@GetMapping("/back")
	String back ( Map<String, Object>map) {
		// 设置页面右下方的jsp路径
		map.put("url", "collegeinfo/major/main.jsp");
		return "main";
	}
	
	@GetMapping("/update")
	String update (String id, Map<String, Object> map){
		MajorDto dto = majorService.getById(id);
		map.put("major", dto);
		map.put("url", "collegeinfo/major/update.jsp");
		return "main";
	}
	
	@PostMapping("/update")
	String update (MajorDto dto, Map<String, Object> map){
		majorService.update(dto);
		map.put("url", "collegeinfo/major/main.jsp");
		return "main";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	WoResultCode delete (String[] id){
		majorService.delete (id);
		return WoResultCode.getSuccessCode().setMsg("成功删除菜单...");
	}

	@PostMapping("/selector")
	String loadSelector (WoSelectorParams params,Map<String,Object>map){
		map.put("selectorParams",WoJsonUtil.toString(params));
		return "collegeinfo/major/selector";
	}

	@RequestMapping("/selector/list")
	@ResponseBody
	WoDataTable<MajorDto> getDataTable (Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir,String params,Map<String, Object> map){
		WoPage<MajorDto> page = majorService.getPageData(start, length, searchContent, dir,params);
		return new WoDataTable<>(page, draw);
	}
}