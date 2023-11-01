package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.dal.dao.UsersDAO;
import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.service.convert.UsersConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public int add(UsersBO usersBO){
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        return usersDAO.insert(usersDO);
    }

    @Override
    public int update(UsersBO usersBO){
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        return usersDAO.updateByPrimaryKeySelective(usersDO);
    }

    /**
     *
     * @param usersQuery
     * @return
     */
    private Example convertExample(UsersQuery usersQuery) {
        Example example = new Example(UsersDO.class);
        Example.Criteria criteria = example.createCriteria();
        if (!ObjectUtils.isEmpty(usersQuery.getUserId())) {
            criteria.andEqualTo("userId", usersQuery.getUserId());
        }
        return example;
    }
}
