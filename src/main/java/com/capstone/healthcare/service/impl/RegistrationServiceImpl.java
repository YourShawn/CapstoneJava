package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.dal.jpa.UsersJPA;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.service.convert.UsersConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersJPA usersJPA;

    @Override
    public void add(UsersBO usersBO){
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        usersJPA.save(usersDO);
    }

    @Override
    public void update(UsersBO usersBO){
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        usersJPA.save(usersDO);
    }

    /**
     *
     * @param usersQuery
     * @return
     */
//    private Example convertExample(UsersQuery usersQuery) {
//        Example example = new Example(UsersDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(usersQuery.getUserId())) {
//            criteria.andEqualTo("userId", usersQuery.getUserId());
//        }
//        return example;
//    }




    private Example<UsersDO> convertExampleJPA(UsersQuery query) {
        UsersDO probe = new UsersDO();
        if (!ObjectUtils.isEmpty(query.getUserId())) {
            probe.setUserId(query.getUserId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<UsersDO> example = Example.of(probe, matcher);
        return example;
    }


}
