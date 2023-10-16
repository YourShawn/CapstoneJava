package com.iaminca.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.MedicationsQuery;
import com.capstone.healthcare.service.MedicationsService;
import com.capstone.healthcare.service.bo.MedicationsBO;
import com.capstone.healthcare.web.convert.MedicationsConvert;
import com.iaminca.entity.dto.MedicationsDTO;
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
@RequestMapping("/medications")
public class MedicationsController {
	@Autowired
	private MedicationsService medicationsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody MedicationsQuery query){
		PageListResult<MedicationsBO> pagerResult = medicationsService.findPage(query);

		List<MedicationsDTO> MedicationsDTOS = MedicationsConvert.toDTOList(pagerResult.getList());
		PageListResult<MedicationsDTO> page = new PageListResult<>(MedicationsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody MedicationsDTO medicationsDTO){
		MedicationsBO medicationsBO = MedicationsConvert.toBO(medicationsDTO);
        return new ResultModel(medicationsService.add(medicationsBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody MedicationsDTO medicationsDTO){
		MedicationsBO medicationsBO = MedicationsConvert.toBO(medicationsDTO);
        return new ResultModel(medicationsService.update(medicationsBO));
	}

}
