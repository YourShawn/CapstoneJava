package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.handle.UserHandler;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.web.convert.RegisterConvert;
import com.capstone.healthcare.web.dto.UsersDTO;
import jakarta.annotation.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserHandler userHandler;

	/**
	 * Adding new data
	 */
	@GetMapping("/findPage")
	public ResultModel findPage(UsersQuery query){
		PageListResult<UsersBO> page = userHandler.findPage(query);
		List<UsersDTO> dtoList = RegisterConvert.toDTOList(page.getList());
		PageListResult<UsersDTO> pageResult = new PageListResult<>(dtoList,page.getPageNum(),page.getPageSize(),page.getTotal());
		return new ResultModel(pageResult);
	}
	/**
	 * find info
	 */
	@GetMapping("/getInfo")
	public ResultModel getInfo( UsersQuery query){
		if(ObjectUtils.isEmpty(query.getUserId())){
			return new ResultModel();
		}
		UsersBO userInfo = userHandler.findUserInfo(query);
		return new ResultModel(userInfo);
	}
}
