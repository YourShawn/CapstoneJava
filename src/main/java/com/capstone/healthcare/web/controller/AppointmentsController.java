package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.AppointmentHandler;
import com.capstone.healthcare.handle.PatientHandler;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.*;
import com.capstone.healthcare.web.convert.AppointmentsConvert;
import com.capstone.healthcare.web.dto.AppointmentsDTO;
import jakarta.annotation.Resource;
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
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
	@Autowired
	private AppointmentsService appointmentsService;
	@Resource
	private AppointmentHandler appointmentHandler;
	@Resource
	private PatientHandler patientHandler;


	
	/**
	 * Pagination
	 */
	@GetMapping("/findPage")
	public ResultModel findPageInfo(AppointmentsQuery query){
		PageListResult<AppointmentsBO> pagerResult = appointmentHandler.findPage(query);

		List<AppointmentsDTO> AppointmentsDTOS = AppointmentsConvert.toDTOList(pagerResult.getList());
		PageListResult<AppointmentsDTO> page = new PageListResult<>(AppointmentsDTOS,pagerResult.getPageNum(),pagerResult.getPageSize(),pagerResult.getTotal());
		return new ResultModel(page);
	}


	/**
	 * Pagination
	 */
	@GetMapping("/findGroupDays")
	public ResultModel findGroupDays(AppointmentsQuery query){
		List<AppointmentsByDayBO> pagerResult = appointmentsService.findGroupDays();
		pagerResult.sort((item1,item2)->{
			return item1.getDay().compareTo(item2.getDay());
		});
		return new ResultModel(pagerResult);
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
		List<AppointmentsByPatientNameBO> appointmentsDTOList =
				appointmentsService.findListWithPatientName(appointmentsQuery);
		return new ResultModel(appointmentsDTOList);
	}


	/**
	 *  get appointment list
	 */
	@GetMapping("/getInfo")
	public ResultModel getInfo( AppointmentsQuery appointmentsQuery) {
		if(ObjectUtils.isEmpty(appointmentsQuery.getAppointmentId())){
			return new ResultModel();
		}
		List<AppointmentsBO> list = appointmentsService.findList(appointmentsQuery);
		if(CollectionUtils.isEmpty(list)){
			return new ResultModel();
		}
		PatientsQuery query = new PatientsQuery();
		query.setPatientId(list.get(0).getPatientId());
		List<PatientsBO> list1 = patientHandler.findList(query);
		AppointmentsDTO appointmentsDTO =
				AppointmentsConvert.toDTO(list.get(0));
		appointmentsDTO.setPatientName(list1.get(0).getFirstName() + " " + list1.get(0).getLastName());
		return new ResultModel(appointmentsDTO);
	}

	@RequestMapping("/getPatientAppointmentsList")
	@ResponseBody
	public ResultModel getPatientAppointmentsList(@RequestBody AppointmentsQuery appointmentsQuery) {
		List<AppointmentsBO> appointmentsDTOList =
				appointmentsService.findList(appointmentsQuery);
		return new ResultModel(appointmentsDTOList);
	}

	@RequestMapping("/getUpcomingAppointments")
	@ResponseBody
	public ResultModel getUpcomingAppointments(@RequestBody AppointmentsQuery appointmentsQuery) {
		List<AppointmentsUpcomingBO> appointmentsDTOList =
				appointmentsService.getUpcomingAppointments(appointmentsQuery);
		return new ResultModel(appointmentsDTOList);
	}
}
