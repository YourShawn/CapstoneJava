package com.capstone.healthcare.web.controller;

import com.capstone.healthcare.common.ResultModel;
import com.capstone.healthcare.dal.dao.UsersDAO;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.service.convert.UsersConvert;
import com.capstone.healthcare.web.convert.AppointmentsConvert;
import com.capstone.healthcare.web.convert.RegisterConvert;
import com.capstone.healthcare.web.dto.AppointmentsDTO;
import com.capstone.healthcare.web.dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        registrationService.add(usersBO);
        return new ResultModel();
    }

    /**
     * update
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultModel update(@RequestBody UsersDTO usersDTO){
        UsersBO usersBO = RegisterConvert.toBO(usersDTO);
        registrationService.update(usersBO);
        return new ResultModel();
    }

    @RequestMapping("/getUserData")
    @ResponseBody
    public ResultModel getUserData(@RequestBody UsersQuery usersQuery) {
        List<UsersDTO> appointmentsDTOList =
                RegisterConvert.toDTOList(registrationService.findList(usersQuery));
        return new ResultModel(appointmentsDTOList);
    }

}
