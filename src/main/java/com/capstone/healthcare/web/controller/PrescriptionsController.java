package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.PrescriptionsQuery;
import com.capstone.healthcare.service.PrescriptionsService;
import com.capstone.healthcare.service.bo.PrescriptionsBO;
import com.capstone.healthcare.web.convert.PrescriptionsConvert;
import com.iaminca.entity.dto.PrescriptionsDTO;
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
@RequestMapping("/prescriptions")
public class PrescriptionsController {
	@Autowired
	private PrescriptionsService prescriptionsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody PrescriptionsQuery query){
		PageListResult<PrescriptionsBO> pagerResult = prescriptionsService.findPage(query);

		List<PrescriptionsDTO> PrescriptionsDTOS = PrescriptionsConvert.toDTOList(pagerResult.getList());
		PageListResult<PrescriptionsDTO> page = new PageListResult<>(PrescriptionsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody PrescriptionsDTO prescriptionsDTO){
		PrescriptionsBO prescriptionsBO = PrescriptionsConvert.toBO(prescriptionsDTO);
		prescriptionsService.add(prescriptionsBO);
        return new ResultModel();
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

}
