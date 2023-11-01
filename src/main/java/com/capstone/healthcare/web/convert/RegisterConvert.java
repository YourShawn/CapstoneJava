package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.web.dto.UsersDTO;
import org.springframework.beans.BeanUtils;

public class RegisterConvert {

    public static UsersBO toBO(UsersDTO usersDTO) {
        if (usersDTO == null) {
            return null;
        }

        UsersBO usersBO = new UsersBO();
        BeanUtils.copyProperties(usersDTO, usersBO);
        return usersBO;
    }

    public static UsersDTO toDTO(UsersBO usersBO) {
        if (usersBO == null) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();
        BeanUtils.copyProperties(usersBO, usersDTO);
        return usersDTO;
    }

}
