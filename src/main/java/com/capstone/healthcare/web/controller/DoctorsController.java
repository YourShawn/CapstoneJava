package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.DoctorsHandler;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.DoctorsQuery;
import com.capstone.healthcare.query.PatientsQuery;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.DoctorsBO;
import com.capstone.healthcare.service.bo.PatientsBO;
import com.capstone.healthcare.web.convert.AppointmentsConvert;
import com.capstone.healthcare.web.convert.DoctorsConvert;
import com.capstone.healthcare.web.convert.PatientsConvert;
import com.capstone.healthcare.web.convert.RegisterConvert;
import com.capstone.healthcare.web.dto.*;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctors")
public class DoctorsController {
	@Resource
	private DoctorsHandler doctorsHandler;



	/**
	 * Pagination
	 */
	@GetMapping("/findPage")
	public ResultModel findPageInfo(DoctorsQuery query){
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


	/**
	 * find info
	 */
	@GetMapping("/getInfo")
	public ResultModel getInfo( DoctorsQuery query){
		if(ObjectUtils.isEmpty(query.getDoctorId())){
			return new ResultModel();
		}
		List<DoctorsBO> list = doctorsHandler.findList(query);
		if(CollectionUtils.isEmpty(list)){
			return new ResultModel();
		}
		return new ResultModel(list.get(0));
	}

	@RequestMapping("/getDoctorId")
	@ResponseBody
	public ResultModel getDoctorId(@RequestBody DoctorsQuery doctorsQuery) {
		List<DoctorsDTO> doctorsDTOList = DoctorsConvert.toDTOList(doctorsHandler.findList(doctorsQuery));

		Integer doctorId = null;

		if (!doctorsDTOList.isEmpty()) {
			doctorId = doctorsDTOList.get(0).getDoctorId();
		}

		return new ResultModel(doctorId);
	}

	@RequestMapping("/getDoctorName")
	@ResponseBody
	public ResultModel getDoctorName(@RequestBody DoctorsQuery doctorsQuery) {
		List<DoctorsDTO> doctorsDTOList = DoctorsConvert.toDTOList(doctorsHandler.findList(doctorsQuery));
		String doctorName = null;

		if (!doctorsDTOList.isEmpty()) {
			doctorName = doctorsDTOList.get(0).getDoctorName();
		}

		return new ResultModel(doctorName);
	}

	@GetMapping("/getDoctorsList")
	@ResponseBody
	public ResultModel getDoctorsList() {
		List<DoctorsListDTO> doctorsDTOList = doctorsHandler.findList();
		return new ResultModel(doctorsDTOList);
	}


}
