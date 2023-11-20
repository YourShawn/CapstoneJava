package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.web.convert.AppointmentsConvert;
import com.capstone.healthcare.web.dto.AppointmentsDTO;
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
@RequestMapping("/appointments")
public class AppointmentsController {
	@Autowired
	private AppointmentsService appointmentsService;


	
	/**
	 * Pagination
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public ResultModel findPageInfo(@RequestBody AppointmentsQuery query){
		PageListResult<AppointmentsBO> pagerResult = appointmentsService.findPage(query);

		List<AppointmentsDTO> AppointmentsDTOS = AppointmentsConvert.toDTOList(pagerResult.getList());
		PageListResult<AppointmentsDTO> page = new PageListResult<>(AppointmentsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}

	/**
	 * Adding new data
	 */
	@RequestMapping("/add")
	@ResponseBody
	public ResultModel add(@RequestBody AppointmentsDTO appointmentsDTO){
		AppointmentsBO appointmentsBO = AppointmentsConvert.toBO(appointmentsDTO);
		appointmentsService.add(appointmentsBO);
        return new ResultModel();
	}
	
	/**
	 * update
	 */
	@RequestMapping("/update")
	@ResponseBody
	public ResultModel update(@RequestBody AppointmentsDTO appointmentsDTO){
		AppointmentsBO appointmentsBO = AppointmentsConvert.toBO(appointmentsDTO);
		appointmentsService.update(appointmentsBO);
        return new ResultModel();
	}

	/**
	 *  get appointment list
	 */
	@RequestMapping("/getAppointmentsList")
	@ResponseBody
	public ResultModel getAppointmentList(@RequestBody AppointmentsQuery appointmentsQuery) {
		List<AppointmentsDTO> appointmentsDTOList =
				AppointmentsConvert.toDTOList(appointmentsService.findList(appointmentsQuery));
		return new ResultModel(appointmentsDTOList);
	}
}
