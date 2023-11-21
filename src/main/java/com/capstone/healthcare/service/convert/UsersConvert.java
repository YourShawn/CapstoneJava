package com.capstone.healthcare.service.convert;

import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.UsersBO;
import com.google.common.collect.Lists;
import org.hsqldb.rights.User;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

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

    public static List<UsersBO> toBOList(List<UsersDO> doList) {
        if (CollectionUtils.isEmpty(doList)) {
            return Collections.emptyList();
        }
        List<UsersBO> boList = Lists.newArrayList();
        for (UsersDO usersDO : doList) {
            if (usersDO != null) {
                boList.add(toBO(usersDO));
            }
        }
        return boList;
    }

}
