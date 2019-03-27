package com.dream.ems.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dream.ems.dto.OperationLogDto;
import com.dream.ems.service.OperationLogService;

import wo.bsys.util.BSysConstant;
import wo.bsys.vo.WoDataTable;
import wo.common.entity.WoPage;

@Controller
@RequestMapping("/operationLog")
@SessionAttributes(BSysConstant.SESSION_USER)
public class OperationLogController {
	@Autowired
	private OperationLogService operationLogService;
	@RequestMapping("/list")
	@ResponseBody
	public WoDataTable<OperationLogDto> getDataTable(Integer draw, Long start, Long length,
			@RequestParam("search[value]") String searchContent, @RequestParam("order[0][dir]") String dir, Map<String, Object> map){
			WoPage<OperationLogDto> page = operationLogService.getPageData(start,length,searchContent,dir);
		return new WoDataTable<>(page, draw);
	}
}
