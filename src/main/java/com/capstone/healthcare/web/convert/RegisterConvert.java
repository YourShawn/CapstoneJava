package com.capstone.healthcare.web.convert;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.web.dto.AppointmentsDTO;
import com.capstone.healthcare.web.dto.UsersDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

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

    public static List<UsersDTO> toDTOList(List<UsersBO> boList) {
        if (CollectionUtils.isEmpty(boList)) {
            return Collections.emptyList();
        }

        List<UsersDTO> dtoList = Lists.newArrayList();
        for (UsersBO usersBO : boList) {
            if (usersBO != null) {
                dtoList.add(toDTO(usersBO));
            }
        }
        return dtoList;
    }
}
