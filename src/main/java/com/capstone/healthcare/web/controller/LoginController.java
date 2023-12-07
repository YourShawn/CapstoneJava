package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.handle.LoginHandler;
import com.capstone.healthcare.service.bo.LoginBO;
import com.capstone.healthcare.web.dto.LoginDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 14:42:09
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {
	@Resource
	private LoginHandler loginHandler;



	/**
	 * Adding new data
	 */
	@RequestMapping("/adminLogin")
	@ResponseBody
	public ResultModel adminLogin(@RequestBody LoginDTO loginDTO){
		LoginBO bo = new LoginBO();
		bo.setUsername(loginDTO.getUsername());
		bo.setPassword(loginDTO.getPassword());
		String login = loginHandler.adminLogin(bo);
		return new ResultModel(login);
	}



	/**
	 * Adding new data
	 */
	@RequestMapping("/doctorLogin")
	@ResponseBody
	public ResultModel doctorLogin(@RequestBody LoginDTO loginDTO){
		LoginBO bo = new LoginBO();
		bo.setUsername(loginDTO.getUsername());
		bo.setPassword(loginDTO.getPassword());
		String login = loginHandler.doctorLogin(bo);
		return new ResultModel(login);
	}


	/**
	 * Adding new data
	 */
	@RequestMapping("/patientLogin")
	@ResponseBody
	public ResultModel patientLogin(@RequestBody LoginDTO loginDTO){
		LoginBO bo = new LoginBO();
		bo.setUsername(loginDTO.getUsername());
		bo.setPassword(loginDTO.getPassword());
		String login = loginHandler.patientLogin(bo);
		return new ResultModel(login);
	}

}
