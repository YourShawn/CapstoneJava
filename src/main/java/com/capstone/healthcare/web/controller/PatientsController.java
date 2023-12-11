package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.PatientsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.web.convert.DoctorsConvert;
import com.capstone.healthcare.web.convert.PatientsConvert;
import com.capstone.healthcare.web.dto.DoctorsDTO;
import com.capstone.healthcare.web.dto.PatientsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
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
	@GetMapping("/findPage")
	public ResultModel findPageInfo(PatientsQuery query){
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
		System.out.println("patientsDTO:-->"+patientsDTO.getFirstName());
		PatientsBO patientsBO = PatientsConvert.toBO(patientsDTO);
		patientsService.add(patientsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody PatientsDTO patientsDTO){
		PatientsBO patientsBO = PatientsConvert.toBO(patientsDTO);
		patientsService.update(patientsBO);
        return new ResultModel();
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

	/**
	 * get patient data
	 */
	@RequestMapping("/getPatientDetail")
	@ResponseBody
	public ResultModel getPatientDetail(@RequestBody PatientsQuery query){
		List<PatientsBO> patientDtl = patientsService.findList(query);
		List<PatientsDTO> patientsList = PatientsConvert.toDTOList(patientDtl);
		return  new ResultModel(patientsList);
	}

	/**
	 * find info
	 */
	@GetMapping("/getInfo")
	public ResultModel getInfo( PatientsQuery query){
		if(ObjectUtils.isEmpty(query.getPatientId())){
			return new ResultModel();
		}
		List<PatientsBO> list = patientsService.findList(query);
		if(CollectionUtils.isEmpty(list)){
			return new ResultModel();
		}
		return new ResultModel(list.get(0));
	}

	@RequestMapping("/getPatientId")
	@ResponseBody
	public ResultModel getPatientId(@RequestBody PatientsQuery patientsQuery) {
		List<PatientsDTO> patientsDTOList = PatientsConvert.toDTOList(patientsService.findList(patientsQuery));

		Integer patientId = null;

		if (!patientsDTOList.isEmpty()) {
			patientId = patientsDTOList.get(0).getPatientId();
		}

		return new ResultModel(patientId);
	}


}
