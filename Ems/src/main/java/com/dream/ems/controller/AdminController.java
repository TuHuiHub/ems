package com.dream.ems.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.AdminDto;
import com.dream.ems.service.AdminService;

import wo.bsys.dto.DictionaryDto;
import wo.bsys.service.DictionaryService;
import wo.bsys.util.BSysConstant;
import wo.bsys.vo.WoDataTable;
import wo.common.entity.WoPage;
import wo.common.exception.WoResultCode;

@Controller
@RequestMapping("/staff/admin")
@SessionAttributes(BSysConstant.SESSION_USER)
public class AdminController {
	private Logger LOG = LogManager.getLogger(AdminController.class);
	

	@Autowired // @Autowired
	private AdminService adminService;
	@Resource
	private DictionaryService dictionaryService;
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<AdminDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir) {
		WoPage<AdminDto> page = adminService.getPageData(start, length, searchContent, dir);
		return new WoDataTable<AdminDto>(page, draw);
	}
	
	@GetMapping("/create")
	public String create(Map<String,Object>map){
		map.put("url","admin/staff/a_create.jsp");
		List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
		map.put("genders",genders);
		return "main";
	}
	
	@PostMapping("/create")
	public String create(AdminDto dto,Map<String,Object>map){
		adminService.createAdmin(dto);
		return "redirect:/";
	}
	@GetMapping("/update")
	public String update(String id,Map<String,Object>map){
		AdminDto dto = adminService.findById(id);
		List<DictionaryDto> genders = dictionaryService.getAllByDicType("gender");
		map.put("formData",dto);
		map.put("genders",genders);
		map.put("url","admin/staff/a_update.jsp");
		return "main";
	}
	@PostMapping("/update")
	public String update(AdminDto dto,Map<String, Object>map){
		LOG.info(111);
		adminService.updateAdmin(dto);
		LOG.info(dto);
		return "redirect:/";
	}
	@PostMapping("/delete")
	@ResponseBody
	public WoResultCode delete(String[] id){
		adminService.delete(id);
		return WoResultCode.getSuccessCode().setMsg("删除管理员用户成功！");
	}
}
