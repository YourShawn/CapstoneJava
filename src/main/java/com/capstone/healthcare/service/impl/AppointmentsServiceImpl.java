package com.capstone.healthcare.service.impl;


import com.capstone.healthcare.common.modules.PageListResult;
import com.capstone.healthcare.dal.dataobject.AppointmentsDO;
import com.capstone.healthcare.dal.jpa.AppointmentsJPA;
import com.capstone.healthcare.dal.jpa.AppointmentsJPA2;
import com.capstone.healthcare.query.AppointmentsQuery;
import com.capstone.healthcare.service.AppointmentsService;
import com.capstone.healthcare.service.bo.AppointmentsBO;
import com.capstone.healthcare.service.bo.AppointmentsByDayBO;
import com.capstone.healthcare.service.bo.AppointmentsByPatientNameBO;
import com.capstone.healthcare.service.bo.AppointmentsUpcomingBO;
import com.capstone.healthcare.service.convert.AppointmentsConvert;
import com.capstone.healthcare.web.dto.DoctorsListDTO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public void update(AppointmentsBO appointmentsBO) {
        // Check if the appointmentId is provided
        Integer appointmentId = appointmentsBO.getAppointmentId();
        if (appointmentId == null) {
            return;
        }

        // Retrieve the existing entity from the database
        Optional<AppointmentsDO> existingAppointmentOpt = appointmentsJPA.findById(appointmentId);
        if (existingAppointmentOpt.isPresent()) {
            AppointmentsDO existingAppointment = existingAppointmentOpt.get();

            // Update only the specified fields from the request
            if (appointmentsBO.getReasonForAppointment() != null) {
                existingAppointment.setReasonForAppointment(appointmentsBO.getReasonForAppointment());
            }
            if(appointmentsBO.getIsActive()!=null){
                existingAppointment.setIsActive(appointmentsBO.getIsActive());
            }
            if(appointmentsBO.getStatus()!=null){
                existingAppointment.setStatus(appointmentsBO.getStatus());
            }

            // Save the updated entity back to the database
            appointmentsJPA.save(existingAppointment);
        } else {
            // Handle the case where the appointmentId doesn't exist
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found with ID: " + appointmentId);
        }
    }

    @Override
    public List<AppointmentsBO> findList(AppointmentsQuery query) {
        List<AppointmentsDO> listByQuery = appointmentsJPA.findAll(this.convertExampleJPA(query));
        return AppointmentsConvert.toBOList(listByQuery);
    }

    @Override
    public List<AppointmentsByPatientNameBO> findListWithPatientName(AppointmentsQuery query) {
        ArrayList<AppointmentsByPatientNameBO> list = Lists.newArrayList();
        int activeAppointments =1 ;
        List<Object[]> listByQuery = appointmentsJPA2.getAppointmentsList(query.getDoctorId(),
                activeAppointments);

        if(CollectionUtils.isEmpty(listByQuery)){
            return list;
        }
        for (Object[] objArray : listByQuery) {
            AppointmentsByPatientNameBO patientNameBO = new AppointmentsByPatientNameBO(
                    (Integer) objArray[0],        // appointmentId
                    (String) objArray[1],         // patientName
                    (Integer) objArray[2],         // doctorId
                    (Date) objArray[3],            // appointmentDateTime
                    (String) objArray[4],         // reasonForAppointment
                    (String) objArray[5],         // status
                    (Integer) objArray[6]          // isActive
            );
            list.add(patientNameBO);
        }

        return list;
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

        if(!ObjectUtils.isEmpty(query.getDoctorId())){
            probe.setDoctorId(query.getDoctorId());
        }

        if(!ObjectUtils.isEmpty(query.getPatientId())){
            probe.setPatientId(query.getPatientId());
        }


        probe.setIsActive(1);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        Example<AppointmentsDO> example = Example.of(probe, matcher);
        return example;
    }

    @Override
    public List<AppointmentsUpcomingBO> getUpcomingAppointments(AppointmentsQuery appointmentsQuery) {
        List<Object[]> listByQuery = appointmentsJPA2.getUpcomingAppointments(appointmentsQuery.getPatientId());
        ArrayList<AppointmentsUpcomingBO> list = Lists.newArrayList();
        if (CollectionUtils.isEmpty(listByQuery)) {
            return list; // Return an empty list if listByQuery is empty
        }
        for (Object[] objArray : listByQuery) {
            AppointmentsUpcomingBO appointmentsUpcomingBO = new AppointmentsUpcomingBO(
                    (String) objArray[0],
                    (String) objArray[1]
            );
            list.add(appointmentsUpcomingBO);
        }
        return list;
    }


}
