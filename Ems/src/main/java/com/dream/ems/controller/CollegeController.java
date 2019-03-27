package com.dream.ems.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.ems.dto.CollegeDto;
import com.dream.ems.po.College;
import com.dream.ems.service.CollegeService;
import com.dream.ems.vo.WoSelectorParams;

import net.sf.json.JSONArray;
import wo.bsys.vo.WoDataTable;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoJsonUtil;

@Controller
@RequestMapping("/collegeinfo/college")
//@SessionAttributes("college")
public class CollegeController {
	
	@Resource // @Autowired
	private CollegeService collegeService;
	
	@GetMapping("/back")
	String back ( Map<String, Object>map) {
		// 设置页面右下方的jsp路径
		map.put("url", "collegeinfo/college/main.jsp");
		return "main";
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<CollegeDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
		WoPage<CollegeDto> page = collegeService.getPageData(start, length, searchContent, dir);
		return new WoDataTable<CollegeDto>(page, draw);
	}
	
	@GetMapping("/create")
	String create (Map<String, Object>map) {
		// 设置页面右下方的jsp路径
		map.put("url", "collegeinfo/college/create.jsp");
		return "main";
	}
	
	@PostMapping("/create")
	String create (CollegeDto dto, Map<String, Object>map) {
		collegeService.create(dto);		
		return "main";
	}
	
	/**
	 * 加载菜单的修改页面
	 * @param map
	 * @return
	 */
	@GetMapping("/update")
	String update (String id, Map<String, Object>map) {
		// 修改表单需要的表单数据
		CollegeDto dto = collegeService.getById (id);
		map.put("college", dto);
		// 主页面右下方页面对应的jsp路径
		map.put("url", "collegeinfo/college/update.jsp");
		return "main";
	}
	
	/**
	 * 提交创建表单
	 * @param dto
	 * @return
	 */
	@PostMapping("/update")
	String update (CollegeDto dto) {
		collegeService.update(dto);
		return "redirect:/";
	}
	
	@PostMapping("/delete")
	@ResponseBody
	WoResultCode delete (String[] id) {
		collegeService.delete (id);
		return WoResultCode.getSuccessCode().setMsg("成功删除菜单...");
	}
	
	@RequestMapping("/getColleges")
	@ResponseBody
	private JSONArray getColleges(Map<String,Object>map){
		List<College> colleges = collegeService.getAllCollege();
		return JSONArray.fromObject(colleges);
	}
	@PostMapping("/selector")
	public String loadSelector(WoSelectorParams params,Map<String,Object>map){
		map.put("selectorParams",WoJsonUtil.toString(params));
		return "collegeinfo/college/selector";
	}
}
