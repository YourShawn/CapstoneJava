package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.web.convert.PatientsConvert;
import com.capstone.healthcare.web.dto.PatientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/patients")
public class PatientsController {
	@Autowired
	private PatientsService patientsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody PatientsQuery query){
		PageListResult<PatientsBO> pagerResult = patientsService.findPage(query);

		List<PatientsDTO> PatientsDTOS = PatientsConvert.toDTOList(pagerResult.getList());
		PageListResult<PatientsDTO> page = new PageListResult<>(PatientsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody PatientsDTO patientsDTO){
		PatientsBO patientsBO = PatientsConvert.toBO(patientsDTO);
        return new ResultModel(patientsService.add(patientsBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody PatientsDTO patientsDTO){
		PatientsBO patientsBO = PatientsConvert.toBO(patientsDTO);
        return new ResultModel(patientsService.update(patientsBO));
	}

	/**
	 * get patient list
	 */
	@RequestMapping("/getAllocatedPatientsList")
	@ResponseBody
	public ResultModel getAllocatedPatientsList(@RequestBody PatientsQuery query){
		List<PatientsBO> allPatients = patientsService.findList(query);
		List<PatientsDTO> patientsList = PatientsConvert.toDTOList(allPatients);
		return  new ResultModel(patientsList);
	}
}
