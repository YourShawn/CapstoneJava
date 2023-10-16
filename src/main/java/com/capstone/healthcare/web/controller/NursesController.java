package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.NursesQuery;
import com.capstone.healthcare.service.NursesService;
import com.capstone.healthcare.service.bo.NursesBO;
import com.capstone.healthcare.web.convert.NursesConvert;
import com.iaminca.entity.dto.NursesDTO;
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
@RequestMapping("/nurses")
public class NursesController {
	@Autowired
	private NursesService nursesService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody NursesQuery query){
		PageListResult<NursesBO> pagerResult = nursesService.findPage(query);

		List<NursesDTO> NursesDTOS = NursesConvert.toDTOList(pagerResult.getList());
		PageListResult<NursesDTO> page = new PageListResult<>(NursesDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody NursesDTO nursesDTO){
		NursesBO nursesBO = NursesConvert.toBO(nursesDTO);
        return new ResultModel(nursesService.add(nursesBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody NursesDTO nursesDTO){
		NursesBO nursesBO = NursesConvert.toBO(nursesDTO);
        return new ResultModel(nursesService.update(nursesBO));
	}

}
