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

    void add(UsersBO usersBO);

    /**
     * 修改数据
     * @param
     * @return
     */
    void update(UsersBO usersBO);
}
