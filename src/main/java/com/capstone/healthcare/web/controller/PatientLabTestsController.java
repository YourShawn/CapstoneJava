package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientLabTestsQuery;
import com.capstone.healthcare.service.PatientLabTestsService;
import com.capstone.healthcare.service.bo.PatientLabTestsBO;
import com.capstone.healthcare.web.convert.PatientLabTestsConvert;
import com.iaminca.entity.dto.PatientLabTestsDTO;
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
@RequestMapping("/patientLabTests")
public class PatientLabTestsController {
	@Autowired
	private PatientLabTestsService patientLabTestsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody PatientLabTestsQuery query){
		PageListResult<PatientLabTestsBO> pagerResult = patientLabTestsService.findPage(query);

		List<PatientLabTestsDTO> PatientLabTestsDTOS = PatientLabTestsConvert.toDTOList(pagerResult.getList());
		PageListResult<PatientLabTestsDTO> page = new PageListResult<>(PatientLabTestsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody PatientLabTestsDTO patientLabTestsDTO){
		PatientLabTestsBO patientLabTestsBO = PatientLabTestsConvert.toBO(patientLabTestsDTO);
		patientLabTestsService.add(patientLabTestsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody PatientLabTestsDTO patientLabTestsDTO){
		PatientLabTestsBO patientLabTestsBO = PatientLabTestsConvert.toBO(patientLabTestsDTO);
		patientLabTestsService.update(patientLabTestsBO);
        return new ResultModel();
	}

}
