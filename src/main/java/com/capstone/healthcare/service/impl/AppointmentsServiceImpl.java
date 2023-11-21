package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.jpa.AppointmentsJPA;
import com.capstone.healthcare.dal.jpa.AppointmentsJPA2;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByDayBO;
import com.capstone.healthcare.service.convert.AppointmentsConvert;
import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author xw
 * @email xw
 * @date 2023-10-16 09:23:19
 */
@Service
public class AppointmentsServiceImpl implements AppointmentsService {

	@Autowired
	private AppointmentsJPA appointmentsJPA;

    @Autowired
    private AppointmentsJPA2 appointmentsJPA2;


    @Override
    public void add(AppointmentsBO appointmentsBO){
        appointmentsBO.setAppointmentId(null);
        AppointmentsDO appointmentsDO = AppointmentsConvert.toDO(appointmentsBO);
		appointmentsJPA.save(appointmentsDO);
    }

    @Override
    public void update(AppointmentsBO appointmentsBO){
		AppointmentsDO appointmentsDO = AppointmentsConvert.toDO(appointmentsBO);
        appointmentsJPA.save(appointmentsDO);
    }

    @Override
    public List<AppointmentsBO> findList(AppointmentsQuery query){
        List<AppointmentsDO> listByQuery = appointmentsJPA.findAll(this.convertExampleJPA(query));
        return AppointmentsConvert.toBOList(listByQuery);
    }

    @Override
    public PageListResult<AppointmentsBO> findPage(AppointmentsQuery pagerCondition){
        Sort sort = Sort.by(Sort.Direction.DESC,"appointmentId");
        PageRequest pageRequest = PageRequest.of(pagerCondition.getPageNum(), pagerCondition.getPageSize(),sort);
        Page<AppointmentsDO> page = appointmentsJPA.findAll(this.convertExampleJPA(pagerCondition), pageRequest);
        //Setting the set of result
        PageListResult<AppointmentsBO> pageListResult = new PageListResult(AppointmentsConvert.toBOList(page.toList()));
        pageListResult.setTotal(page.getTotalElements());
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }

    @Override
    public List<AppointmentsByDayBO> findGroupDays() {
        ArrayList<AppointmentsByDayBO> list = Lists.newArrayList();
        List<Object[]> objects = appointmentsJPA2.groupByDays();
        if(CollectionUtils.isEmpty(objects)){
            return list;
        }
        for(Object[] objArray :objects){
            AppointmentsByDayBO dayBO = new AppointmentsByDayBO(String.valueOf(objArray[0]),(Long)objArray[1]);
            list.add(dayBO);
        }

        return list;
    }

    private org.springframework.data.domain.Example<AppointmentsDO> convertExampleJPA(AppointmentsQuery query) {
        AppointmentsDO probe = new AppointmentsDO();
        if(!ObjectUtils.isEmpty(query.getAppointmentId())){
            probe.setAppointmentId(query.getAppointmentId());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<AppointmentsDO> example = Example.of(probe, matcher);
        return example;
    }


}
