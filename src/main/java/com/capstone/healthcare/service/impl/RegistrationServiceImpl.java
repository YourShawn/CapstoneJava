package com.capstone.healthcare.service.impl;

import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.dataobject.UsersDO;
import com.capstone.healthcare.dal.jpa.UsersJPA;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.query.UsersQuery;
import com.capstone.healthcare.service.RegistrationService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.UsersBO;
import com.capstone.healthcare.service.convert.AppointmentsConvert;
import com.capstone.healthcare.service.convert.UsersConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersJPA usersJPA;

    @Override
    public void add(UsersBO usersBO){
        usersBO.setUserId(null);
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        usersJPA.save(usersDO);
    }

    @Override
    public void update(UsersBO usersBO){
        UsersDO usersDO = UsersConvert.toDO(usersBO);
        usersJPA.updateSelective(usersDO);
    }

    @Override
    public List<UsersBO> findList(UsersQuery query){
        List<UsersDO> listByQuery = usersJPA.findAll(this.convertExampleJPA(query));
        return UsersConvert.toBOList(listByQuery);
    }




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
