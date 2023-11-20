package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DepartmentsQuery;
import com.capstone.healthcare.service.DepartmentsService;
import com.capstone.healthcare.service.bo.DepartmentsBO;
import com.capstone.healthcare.web.convert.DepartmentsConvert;
import com.iaminca.entity.dto.DepartmentsDTO;
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
@RequestMapping("/departments")
public class DepartmentsController {
	@Autowired
	private DepartmentsService departmentsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody DepartmentsQuery query){
		PageListResult<DepartmentsBO> pagerResult = departmentsService.findPage(query);

		List<DepartmentsDTO> DepartmentsDTOS = DepartmentsConvert.toDTOList(pagerResult.getList());
		PageListResult<DepartmentsDTO> page = new PageListResult<>(DepartmentsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody DepartmentsDTO departmentsDTO){
		DepartmentsBO departmentsBO = DepartmentsConvert.toBO(departmentsDTO);
		departmentsService.add(departmentsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody DepartmentsDTO departmentsDTO){
		DepartmentsBO departmentsBO = DepartmentsConvert.toBO(departmentsDTO);
		departmentsService.update(departmentsBO);
        return new ResultModel();
	}

}
