package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.DoctorsService;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.web.convert.DoctorsConvert;
import com.iaminca.entity.dto.DoctorsDTO;
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
@RequestMapping("/doctors")
public class DoctorsController {
	@Autowired
	private DoctorsService doctorsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody DoctorsQuery query){
		PageListResult<DoctorsBO> pagerResult = doctorsService.findPage(query);

		List<DoctorsDTO> DoctorsDTOS = DoctorsConvert.toDTOList(pagerResult.getList());
		PageListResult<DoctorsDTO> page = new PageListResult<>(DoctorsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody DoctorsDTO doctorsDTO){
		DoctorsBO doctorsBO = DoctorsConvert.toBO(doctorsDTO);
        return new ResultModel(doctorsService.add(doctorsBO));
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody DoctorsDTO doctorsDTO){
		DoctorsBO doctorsBO = DoctorsConvert.toBO(doctorsDTO);
        return new ResultModel(doctorsService.update(doctorsBO));
	}

}
