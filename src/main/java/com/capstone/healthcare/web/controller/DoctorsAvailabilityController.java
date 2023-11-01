package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DoctorsAvailabilityQuery;
import com.capstone.healthcare.service.DoctorsAvailabilityService;
import com.capstone.healthcare.service.bo.DoctorsAvailabilityBO;
import com.capstone.healthcare.web.convert.DoctorsAvailabilityConvert;

import com.capstone.healthcare.web.dto.DoctorsAvailabilityDTO;
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
@RequestMapping("/doctorsAvailability")
public class DoctorsAvailabilityController {
	@Autowired
	private DoctorsAvailabilityService doctorsAvailabilityService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody DoctorsAvailabilityQuery query){
		PageListResult<DoctorsAvailabilityBO> pagerResult = doctorsAvailabilityService.findPage(query);

		List<DoctorsAvailabilityDTO> DoctorsAvailabilityDTOS = DoctorsAvailabilityConvert.toDTOList(pagerResult.getList());
		PageListResult<DoctorsAvailabilityDTO> page = new PageListResult<>(DoctorsAvailabilityDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody DoctorsAvailabilityDTO doctorsAvailabilityDTO){
		DoctorsAvailabilityBO doctorsAvailabilityBO = DoctorsAvailabilityConvert.toBO(doctorsAvailabilityDTO);
        return new ResultModel(doctorsAvailabilityService.add(doctorsAvailabilityBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody DoctorsAvailabilityDTO doctorsAvailabilityDTO){
		DoctorsAvailabilityBO doctorsAvailabilityBO = DoctorsAvailabilityConvert.toBO(doctorsAvailabilityDTO);
        return new ResultModel(doctorsAvailabilityService.update(doctorsAvailabilityBO));
	}

}
