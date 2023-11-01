package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.web.convert.RegisterConvert;
import com.capstone.healthcare.web.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 * @author um
 * @email um
 * @date 2023-10-30 14:42:09
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    /**
     * Adding new data
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultModel add(@RequestBody UsersDTO usersDTO){
        UsersBO usersBO = RegisterConvert.toBO(usersDTO);
        return new ResultModel(registrationService.add(usersBO));
    }

    /**
     * update
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultModel update(@RequestBody UsersDTO usersDTO){
        UsersBO usersBO = RegisterConvert.toBO(usersDTO);
        return new ResultModel(registrationService.update(usersBO));
    }
}
