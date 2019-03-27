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

import com.dream.ems.dto.TimeSlotDto;
import com.dream.ems.service.TimeSlotService;
import wo.bsys.vo.WoDataTable;
import wo.bsys.vo.WoSelectorParams;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;
import wo.common.util.WoJsonUtil;
import wo.bsys.util.BSysConstant;

/**
 * 时间段控制器.
 * @author cailei
 */
@Controller
@RequestMapping("/ems/timeSlot")
@SessionAttributes(names = BSysConstant.SESSION_USER)
public class TimeSlotController {

	/**
	 * 注入TimeSlotService.
	 */
    @Resource // @Autowired
	private TimeSlotService timeSlotService;
	
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
	public WoDataTable<TimeSlotDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir
            			) {
		WoPage<TimeSlotDto> page = timeSlotService.getPageData(start, length, searchContent, dir
				);
		return new WoDataTable<TimeSlotDto>(page, draw);
	}
	
	/**
	 * 加载"创建"页面
	 * @return
	 */
	@GetMapping("/create")
	public String create (Map<String, Object> map
				) {
		map.put("url", "timeSlot/create.jsp");
		
				return "main";
	}
	
	/**
	 * 提交"创建"表单
	 * @return
	 */
	@PostMapping("/create")
	public String create (TimeSlotDto dto, Map<String, Object> map) {
		timeSlotService.create(dto);
				return "redirect:/";
			}
	
	/**
	 * 加载"修改"页面
	 * @return
	 */
	@GetMapping("/update")
	public String update (String id, Map<String, Object> map) {
		TimeSlotDto dto = timeSlotService.getById (id);
		map.put("url", "timeSlot/update.jsp");
		map.put("formData", dto);
		return "main";
	}
	
	/**
	 * 提交"修改"表单
	 * @return
	 */
	@PostMapping("/update")
	public String update (TimeSlotDto dto, Map<String, Object> map) {
		timeSlotService.update(dto);
				return "redirect:/";
			}
	
	/**
	 * @param id
	 * @return
	 */
	@PostMapping ("/delete")
	@ResponseBody
	public WoResultCode delete (String[] id) {
		timeSlotService.delete(id);
		return WoResultCode.getSuccessCode().setMsg("删除时间段成功!");
	}
	
		/**
	 * 加载"选择器"页面
	 * @return
	 */
	@PostMapping("/selector")
	public String loadSelector (WoSelectorParams params, Map<String, Object> map) {
		map.put("selectorParams", WoJsonUtil.toString(params));
		return "timeSlot/selector";
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
	public WoDataTable<TimeSlotDto> getSelectorDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
		WoPage<TimeSlotDto> page = timeSlotService.getPageData(start, length, searchContent, dir);
		return new WoDataTable<TimeSlotDto>(page, draw);
	}
	}
