package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.PrescriptionHandler;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.AppointmentsByPatientNameBO;
import com.capstone.healthcare.service.bo.PrescriptionBODetail;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.service.bo.PrescriptionsByYearBO;
import com.capstone.healthcare.web.convert.PrescriptionsConvert;
import com.iaminca.entity.dto.PrescriptionsDTO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * 
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@RestController
@RequestMapping("/prescriptions")
public class PrescriptionsController {
	@Autowired
	private PrescriptionsService prescriptionsService;
	@Resource
	private PrescriptionHandler prescriptionHandler;


	
	/**
	 * Pagination
	 */
	@GetMapping("/findPage")
	public ResultModel findPageInfo( PrescriptionsQuery query){
		PageListResult<PrescriptionsBO> pagerResult = prescriptionsService.findPage(query);

		List<PrescriptionsDTO> PrescriptionsDTOS = PrescriptionsConvert.toDTOList(pagerResult.getList());
		PageListResult<PrescriptionsDTO> page = new PageListResult<>(PrescriptionsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}


	/**
	 * findGroupYear
	 */
	@GetMapping("/findGroupYear")
	public ResultModel findGroupYear(PrescriptionsQuery query){
		List<PrescriptionsByYearBO> pagerResult = prescriptionHandler.findGroupYear();

		return new ResultModel(pagerResult);
	}


	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody PrescriptionsDTO prescriptionsDTO){
		PrescriptionsBO prescriptionsBO = PrescriptionsConvert.toBO(prescriptionsDTO);
		Integer generatedPrescriptionId = prescriptionsService.add(prescriptionsBO);
		ResultModel resultModel = new ResultModel();
		resultModel.setData(generatedPrescriptionId);
        return resultModel;
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody PrescriptionsDTO prescriptionsDTO){
		PrescriptionsBO prescriptionsBO = PrescriptionsConvert.toBO(prescriptionsDTO);
		prescriptionsService.update(prescriptionsBO);
        return new ResultModel();
	}

	@RequestMapping("/getPrescriptionDetail")
	@ResponseBody
	public ResultModel getPrescriptionDetail(@RequestBody PrescriptionsQuery prescriptionsQuery) {
		List<PrescriptionBODetail> prescriptionLst =
				prescriptionsService.getPrescriptionDetail(prescriptionsQuery);
		return new ResultModel(prescriptionLst);
	}
}
