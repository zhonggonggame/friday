package com.sxbang.friday.controller;

import com.sxbang.friday.base.result.Results;
import com.sxbang.friday.dto.BeanField;
import com.sxbang.friday.dto.GenerateDetail;
import com.sxbang.friday.dto.GenerateInput;
import com.sxbang.friday.service.GenerateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 代码生成接口
 *
 */
@Api(tags = "代码生成")
@Controller
@RequestMapping("/generate")
public class GenerateController {

	@Autowired
	private GenerateService generateService;

	//查找数据空中所有表
	@ApiOperation("显示数据库中的所有表名")
	@RequestMapping("/tableNames")
	@ResponseBody
	public Results generateTableNamesView(){
		List tablesList=generateService.findTables();
		return  Results.success(1,tablesList);
	}

	@ApiOperation("根据表名显示表信息")//接口说明,表的字段，数据类型，注释，默认值
	@GetMapping("/index")
	@ResponseBody
	public GenerateDetail generateByTableName(String tableName) {
		GenerateDetail detail = new GenerateDetail();
		detail.setBeanName(generateService.upperFirstChar(tableName));
		List<BeanField> fields = generateService.listBeanField(tableName);
		detail.setFields(fields);
		return detail;
	}

	@ApiOperation("生成代码")
	@PostMapping(value = "/save")
	@ResponseBody
	public void save(@RequestBody GenerateInput input) {
		generateService.saveCode(input);
	}

}
