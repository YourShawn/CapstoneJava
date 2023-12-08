package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.handle.LoginHandler;
import com.capstone.healthcare.service.bo.AdminUserTokenBO;
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
@RequestMapping("/")
public class LoginController {
	@Resource
	private LoginHandler loginHandler;

	/**
	 * Adding new data
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ResultModel login(@RequestBody LoginDTO loginDTO){
		LoginBO bo = new LoginBO();
		bo.setUsername(loginDTO.getUsername());
		bo.setPassword(loginDTO.getPassword());
		bo.setRole(loginDTO.getRole());
		String login = loginHandler.userLogin(bo);
		return new ResultModel(login);
	}


	/**
	 * Adding new data
	 */
	@GetMapping("/getInfo")
	public ResultModel getInfo(@RequestHeader(name = "loginToken") String token){
		AdminUserTokenBO info = loginHandler.getInfo(token);
		return new ResultModel(info);
	}
}
