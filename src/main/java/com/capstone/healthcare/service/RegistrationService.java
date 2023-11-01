package com.capstone.healthcare.service;

import com.capstone.healthcare.service.bo.UsersBO;

/**
 *
 *
 * @author um
 * @email um
 * @date 2023-10-30 09:23:19
 */
public interface RegistrationService {

    int add(UsersBO usersBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    int update(UsersBO usersBO);
}
