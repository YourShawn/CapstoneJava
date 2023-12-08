package com.capstone.healthcare.web.controller;

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
		medicationsService.add(medicationsBO);
        return new ResultModel();
	}

	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody MedicationsDTO medicationsDTO){
		MedicationsBO medicationsBO = MedicationsConvert.toBO(medicationsDTO);
		medicationsService.update(medicationsBO);
        return new ResultModel();
	}

	@RequestMapping("/addMedications")
	@ResponseBody
	public ResultModel add(@RequestBody List<MedicationsDTO> medicationsDTOList) {
		System.out.println("medicationsDTOList:==>"+medicationsDTOList);
		// Convert the list of DTOs to a list of BOs
		List<MedicationsBO> medicationsBOList = MedicationsConvert.toBOList(medicationsDTOList);

		// Call the service method for bulk insert
		medicationsService.addBulk(medicationsBOList);

		return new ResultModel();
	}




}
