package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.MedicalRecordsQuery;
import com.capstone.healthcare.service.MedicalRecordsService;
import com.capstone.healthcare.service.bo.MedicalRecordsBO;
import com.capstone.healthcare.web.convert.MedicalRecordsConvert;
import com.iaminca.entity.dto.MedicalRecordsDTO;
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
        return new ResultModel(medicalRecordsService.add(medicalRecordsBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody MedicalRecordsDTO medicalRecordsDTO){
		MedicalRecordsBO medicalRecordsBO = MedicalRecordsConvert.toBO(medicalRecordsDTO);
        return new ResultModel(medicalRecordsService.update(medicalRecordsBO));
	}

}
