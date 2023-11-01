package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.service.bo.UsersBO;
import org.springframework.beans.BeanUtils;

public class UsersConvert {
    public static UsersBO toBO(UsersDO usersDO) {
        if (usersDO == null) {
            return null;
        }

        UsersBO usersBO = new UsersBO();
        BeanUtils.copyProperties(usersDO, usersBO);
        return usersBO;
    }

    public static UsersDO toDO(UsersBO usersBO) {
        if (usersBO == null) {
            return null;
        }

        UsersDO usersDO = new UsersDO();
        BeanUtils.copyProperties(usersBO, usersDO);
        return usersDO;
    }

}
