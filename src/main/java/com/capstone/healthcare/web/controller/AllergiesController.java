package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AllergiesQuery;
import com.capstone.healthcare.service.AllergiesService;
import com.capstone.healthcare.service.bo.AllergiesBO;
import com.capstone.healthcare.web.convert.AllergiesConvert;
import com.capstone.healthcare.web.dto.AllergiesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@RestController
@RequestMapping("/allergies")
public class AllergiesController {
	@Autowired
	private AllergiesService allergiesService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody AllergiesQuery query){
		PageListResult<AllergiesBO> pagerResult = allergiesService.findPage(query);

		List<AllergiesDTO> AllergiesDTOS = AllergiesConvert.toDTOList(pagerResult.getList());
		PageListResult<AllergiesDTO> page = new PageListResult<>(AllergiesDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody AllergiesDTO allergiesDTO){
		AllergiesBO allergiesBO = AllergiesConvert.toBO(allergiesDTO);
        return new ResultModel(allergiesService.add(allergiesBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody AllergiesDTO allergiesDTO){
		AllergiesBO allergiesBO = AllergiesConvert.toBO(allergiesDTO);
        return new ResultModel(allergiesService.update(allergiesBO));
	}

}
