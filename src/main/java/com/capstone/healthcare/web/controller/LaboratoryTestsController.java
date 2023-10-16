package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.LaboratoryTestsQuery;
import com.capstone.healthcare.service.LaboratoryTestsService;
import com.capstone.healthcare.service.bo.LaboratoryTestsBO;
import com.capstone.healthcare.web.convert.LaboratoryTestsConvert;
import com.iaminca.entity.dto.LaboratoryTestsDTO;
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
@RequestMapping("/laboratoryTests")
public class LaboratoryTestsController {
	@Autowired
	private LaboratoryTestsService laboratoryTestsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody LaboratoryTestsQuery query){
		PageListResult<LaboratoryTestsBO> pagerResult = laboratoryTestsService.findPage(query);

		List<LaboratoryTestsDTO> LaboratoryTestsDTOS = LaboratoryTestsConvert.toDTOList(pagerResult.getList());
		PageListResult<LaboratoryTestsDTO> page = new PageListResult<>(LaboratoryTestsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody LaboratoryTestsDTO laboratoryTestsDTO){
		LaboratoryTestsBO laboratoryTestsBO = LaboratoryTestsConvert.toBO(laboratoryTestsDTO);
        return new ResultModel(laboratoryTestsService.add(laboratoryTestsBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody LaboratoryTestsDTO laboratoryTestsDTO){
		LaboratoryTestsBO laboratoryTestsBO = LaboratoryTestsConvert.toBO(laboratoryTestsDTO);
        return new ResultModel(laboratoryTestsService.update(laboratoryTestsBO));
	}

}
