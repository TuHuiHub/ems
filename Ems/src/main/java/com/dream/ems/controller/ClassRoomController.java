package com.dream.ems.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.ClassRoomDto;
import com.dream.ems.service.ClassRoomService;
import wo.bsys.vo.WoDataTable;
import wo.bsys.vo.WoSelectorParams;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoJsonUtil;
import wo.bsys.util.BSysConstant;

/**
 * 教室控制器.
 * @author cailei
 */
@Controller
@RequestMapping("/ems/classRoom")
@SessionAttributes(names = BSysConstant.SESSION_USER)
public class ClassRoomController {

	/**
	 * 注入ClassRoomService.
	 */
	@Resource // @Autowired
	private ClassRoomService classRoomService;

	/**
	 * @param draw DataTable控件请求序列号,返回数据时需要设置该值
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<ClassRoomDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir
			) {
		WoPage<ClassRoomDto> page = classRoomService.getPageData(start, length, searchContent, dir
				);
		return new WoDataTable<ClassRoomDto>(page, draw);
	}

	/**
	 * 加载"创建"页面
	 * @return
	 */
	@GetMapping("/create")
	public String create (Map<String, Object> map
			) {
		map.put("url", "classRoom/create.jsp");

		return "main";
	}

	/**
	 * 提交"创建"表单
	 * @return
	 */
	@PostMapping("/create")
	public String create (ClassRoomDto dto, Map<String, Object> map) {
		classRoomService.create(dto);
		return "redirect:/";
	}

	/**
	 * 加载"修改"页面
	 * @return
	 */
	@GetMapping("/update")
	public String update (String id, Map<String, Object> map) {
		ClassRoomDto dto = classRoomService.getById (id);
		map.put("url", "classRoom/update.jsp");
		map.put("formData", dto);
		return "main";
	}

	/**
	 * 提交"修改"表单
	 * @return
	 */
	@PostMapping("/update")
	public String update (ClassRoomDto dto, Map<String, Object> map) {
		classRoomService.update(dto);
		return "redirect:/";
	}

	/**
	 * @param id
	 * @return
	 */
	@PostMapping ("/delete")
	@ResponseBody
	public WoResultCode delete (String[] id) {
		classRoomService.delete(id);
		return WoResultCode.getSuccessCode().setMsg("删除教室成功!");
	}

	/**
	 * 加载"选择器"页面
	 * @return
	 */
	@PostMapping("/selector")
	public String loadSelector (WoSelectorParams params, Map<String, Object> map) {
		map.put("selectorParams", WoJsonUtil.toString(params));
		return "classRoom/selector";
	}

	/**
	 * 加载"选择器"列表数据
	 * @param draw DataTable控件请求序列号,返回数据时需要设置该值
	 * @param start 当前页开始索引,从0开始
	 * @param length 当前页最大行数
	 * @param searchContent 查询内容
	 * @param dir 排序方式
	 * @return
	 */
	@RequestMapping("/selector/list")
	@ResponseBody
	public WoDataTable<ClassRoomDto> getSelectorDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
		WoPage<ClassRoomDto> page = classRoomService.getPageData(start, length, searchContent, dir);
		return new WoDataTable<ClassRoomDto>(page, draw);
	}
}
