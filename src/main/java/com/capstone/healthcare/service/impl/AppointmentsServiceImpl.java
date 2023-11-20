package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageHelperAdaptor;
import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.jpa.AppointmentsJPA;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.convert.AppointmentsConvert;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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


    @Override
    public void add(AppointmentsBO appointmentsBO){
        appointmentsBO.setAppointmentId(null);
//        appointmentsBO.setDelFlag(DelFlagEnum.NOT_DEL.getCode());
//        appointmentsBO.setCreateTime(new Date());
//        appointmentsBO.setUpdateTime( appointmentsBO.getCreateTime());
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
        //Setting the parameters of pagination
        pagerCondition.setOrderBy(" ");
        Page page = PageHelperAdaptor.preparePage(pagerCondition, Boolean.TRUE);
        page.setReasonable(Boolean.FALSE);
        List<AppointmentsDO> list = appointmentsJPA.findAll(this.convertExampleJPA(pagerCondition));
        //Setting the set of result
        PageListResult<AppointmentsBO> pageListResult = new PageListResult(AppointmentsConvert.toBOList(list));
        PageHelperAdaptor.setPageResult(page, pageListResult);
        pageListResult.setPageNum(pagerCondition.getPageNum());
        pageListResult.setPageSize(pagerCondition.getPageSize());
        return pageListResult;
    }
    /**
        *
        * @param appointmentsQuery
        * @return
        */
//    private Example convertExample(AppointmentsQuery appointmentsQuery) {
//        Example example = new Example(AppointmentsDO.class);
//        Example.Criteria criteria = example.createCriteria();
//        if (!ObjectUtils.isEmpty(appointmentsQuery.getAppointmentId())) {
//            criteria.andEqualTo("appointmentId", appointmentsQuery.getAppointmentId());
//        }
//
//        if(!ObjectUtils.isEmpty(appointmentsQuery.getDoctorId())) {
//            criteria.andEqualTo("doctorId",appointmentsQuery.getDoctorId());
//        }
//        return example;
//    }


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
