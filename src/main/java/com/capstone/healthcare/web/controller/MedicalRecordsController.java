package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.MedicalRecordsService;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.web.convert.MedicalRecordsConvert;
import com.capstone.healthcare.web.convert.PatientsConvert;
import com.capstone.healthcare.web.dto.PatientsDTO;
import com.iaminca.entity.dto.MedicalRecordsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
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


@RequestMapping("/MedicalRecords")
public class MedicalRecordsController {
	@Autowired
	private MedicalRecordsService medicalRecordsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody MedicalRecordsQuery query){
		PageListResult<MedicalRecordsBO> pagerResult = medicalRecordsService.findPage(query);

		List<MedicalRecordsDTO> MedicalRecordsDTOS = MedicalRecordsConvert.toDTOList(pagerResult.getList());
		PageListResult<MedicalRecordsDTO> page = new PageListResult<>(MedicalRecordsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody MedicalRecordsDTO medicalRecordsDTO){
		MedicalRecordsBO medicalRecordsBO = MedicalRecordsConvert.toBO(medicalRecordsDTO);
		medicalRecordsService.add(medicalRecordsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody MedicalRecordsDTO medicalRecordsDTO){
		MedicalRecordsBO medicalRecordsBO = MedicalRecordsConvert.toBO(medicalRecordsDTO);
		medicalRecordsService.update(medicalRecordsBO);
        return new ResultModel();
	}

	/**
	 * get patient past medical data
	 */
	@RequestMapping("/getPatientsMedicalRecords")
	@ResponseBody
	public ResultModel getPatientDetail(@RequestBody MedicalRecordsQuery query){
		List<MedicalRecordsBO> medicalRecordsDtl = medicalRecordsService.findList(query);
		Comparator<MedicalRecordsBO> dateComparator = Comparator.comparing(MedicalRecordsBO::getDateOfVisit);
		Collections.sort(medicalRecordsDtl, dateComparator.reversed());
		List<MedicalRecordsDTO> medicalRecordsDTOList = MedicalRecordsConvert.toDTOList(medicalRecordsDtl);
		return  new ResultModel(medicalRecordsDTOList);
	}

}
