package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.DoctorsHandler;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.web.convert.DoctorsConvert;
import com.capstone.healthcare.web.dto.DoctorsDTO;
import jakarta.annotation.Resource;
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
	@Resource
	private DoctorsHandler doctorsHandler;



	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody DoctorsQuery query){
		PageListResult<DoctorsBO> pagerResult = doctorsHandler.findPage(query);

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
		doctorsHandler.add(doctorsBO);
        return new ResultModel();
	}

	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody DoctorsDTO doctorsDTO){
		DoctorsBO doctorsBO = DoctorsConvert.toBO(doctorsDTO);
		doctorsHandler.update(doctorsBO);
        return new ResultModel();
	}

}
